package com.lxy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
            }


            @Override
            public void addInterceptors(InterceptorRegistry registry)
            {
                registry.addInterceptor(new ActionInterceptor()).addPathPatterns("/user/getUsers");
                super.addInterceptors(registry);
            }




        };
    }
}
