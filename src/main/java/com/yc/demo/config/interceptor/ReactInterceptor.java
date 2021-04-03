package com.yc.demo.config.interceptor;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuxw
 * @date 2019/4/1
 * @since 1.0
 */
public class ReactInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    private boolean isNeedCheck(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //spring静态资源处理不拦截
        return !(handler instanceof ResourceHttpRequestHandler);
    }
}
