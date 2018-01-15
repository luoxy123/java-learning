package com.lxy.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConfig {
    @Bean
    @Order(1)
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean registrationBean= new FilterRegistrationBean();
        ActionFilter actionFilter = new ActionFilter();
        registrationBean.setFilter(actionFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/user/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;

    }

}
