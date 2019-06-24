package com.sureal.interceptor;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wuxx
 * @date 2019/5/29 18:16
 * @PackageName com.sureal.interceptor
 * @ClassName ChangeViewFilter
 * @Description
 */
@Component
public class ChangeViewInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (modelAndView != null) {
            if (subject != null && subject.isAuthenticated()) {
                modelAndView.addObject("code", 200);
            } else {
                modelAndView.addObject("code", 202);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
