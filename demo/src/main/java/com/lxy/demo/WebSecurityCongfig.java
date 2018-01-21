package com.lxy.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.json.JSONObject;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class WebSecurityCongfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/login").permitAll()
                .antMatchers("/hello").hasAuthority("AUTH_WRITE")
                .antMatchers("/world").hasRole("Admin")
                .anyRequest().authenticated()
                .and().addFilterBefore(new JWTLoginFilter("/login",authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);




    }
    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.customAuthenticationProvider);

    }


}

class AccountCredentials{
    private String  username;
    private String password;

    AccountCredentials() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class GrantedAuthorityImpl implements GrantedAuthority{
    private String authority;
    public GrantedAuthorityImpl(String authority){
        this.authority=authority;
    }

    public void setAuthority(String authority)
    {
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}

class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 30*60*1000;     // 30 minute
    static final String SECRET = "P@ssw02d";            // JWT密码
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key

    static void GenerateAuthentication(HttpServletResponse response,String username,String role) throws IOException {
        //save role
        String JWT = Jwts.builder().claim("authorities",role)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512,SECRET).compact();
//java 中不能把字符串转换成json，不然会报错ObjectMapper的异常
        try{
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(JSONResult.fillResultString(0, "", JWT));

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(HEADER_STRING);
        if(token!=null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();
            String user = claims.getSubject();
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            if(user!=null) {
                return new UsernamePasswordAuthenticationToken(user,null,authorities);

            }

        }
        return  null;


    }
}



class JWTLoginFilter extends AbstractAuthenticationProcessingFilter{

    public JWTLoginFilter(String url, AuthenticationManager authenticationManager){

        super(new AntPathRequestMatcher(url));
        setAuthenticationManager( authenticationManager);
    }




    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        AccountCredentials credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(),AccountCredentials.class);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getUsername(),credentials.getPassword());
        AuthenticationManager authenticationManager= getAuthenticationManager();
        return authenticationManager.authenticate(token);


    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        TokenAuthenticationService.GenerateAuthentication(response,authResult.getName(),authResult.getAuthorities().toString());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
      response.setContentType("application/json");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getOutputStream().print("用户未授权");
    }
}

class JwtAuthenticationFilter extends GenericFilterBean{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication authentication= TokenAuthenticationService.getAuthentication((HttpServletRequest)request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request,response);

    }
}




class JSONResult{
    public static String fillResultString(Integer status, String message, Object result){
        JSONObject jsonObject = new JSONObject(){{
            put("status", status);
            put("message", message);
            put("result", result);
        }};
        return jsonObject.toString();
    }
}



