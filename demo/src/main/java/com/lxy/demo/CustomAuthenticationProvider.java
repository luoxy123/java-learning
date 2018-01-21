package com.lxy.demo;

import com.lxy.demo.user.UserEntity;
import com.lxy.demo.user.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password= authentication.getCredentials().toString();
        UserEntity user = userDao.getUser(name,password);
        if(user!=null){
            ArrayList<GrantedAuthority> authorities= new ArrayList<>();
            authorities.add(new GrantedAuthorityImpl(user.getRole()));
            Authentication auth =new UsernamePasswordAuthenticationToken(name,password,authorities);
            return auth;
        }
        else {
            throw  new BadCredentialsException("用户名或密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
