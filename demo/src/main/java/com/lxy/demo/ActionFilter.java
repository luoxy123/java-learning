package com.lxy.demo;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ActionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Calendar ca = Calendar.getInstance();
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        if(hour < 4){

            HttpServletResponse servletRespons = (HttpServletResponse)response;
            servletRespons.setCharacterEncoding("UTF-8");
            servletRespons.setContentType("application/json;charset=utf-8");

            // 消息

            Map<String, Object> messageMap = new HashMap<>();

            messageMap.put("status","1");

            messageMap.put("message","此接口可以请求时间为:0-4点");

            ObjectMapper objectMapper= new ObjectMapper();

            String writeValueAsString =objectMapper.writeValueAsString(messageMap);

            response.getWriter().write(writeValueAsString);

        }
        else{
            chain.doFilter(request,response);
        }


    }

    @Override
    public void destroy() {

    }
}
