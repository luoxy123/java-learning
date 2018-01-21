package com.lxy.demo;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class ActionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Calendar ca =Calendar.getInstance();
//        int hour = ca.get(Calendar.HOUR_OF_DAY);
//        if(hour <=4)
//        {
//            return true;
//        }
//        HttpServletResponse servletRespons = (HttpServletResponse)response;
//        servletRespons.setCharacterEncoding("UTF-8");
//        servletRespons.setContentType("application/json;charset=utf-8");
//
//        // 消息
//
//        Map<String, Object> messageMap = new HashMap<>();
//
//        messageMap.put("status","1");
//
//        messageMap.put("message","此接口可以请求时间为:0-4点");
//
//        ObjectMapper objectMapper= new ObjectMapper();
//
//        String writeValueAsString =objectMapper.writeValueAsString(messageMap);
//        response.setStatus(400);
//        response.getWriter().write(writeValueAsString);
//
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
