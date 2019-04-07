package com.wayne.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author waynewang
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
//        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
//        System.out.println(((HandlerMethod) handler).getMethod().getName());

        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");


        long end = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("my time interceptor 耗时：" + (end - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

        long end = System.currentTimeMillis();
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("my time interceptor 耗时：" + (end - startTime));
        System.out.println("exception is " + ex);

    }
}
