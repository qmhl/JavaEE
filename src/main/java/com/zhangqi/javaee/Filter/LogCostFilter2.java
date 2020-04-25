package com.zhangqi.javaee.Filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 加上注解 自然就注入到bean中
 * 使用@WebFilter  和前面的LogCostFilter加上FilterConfig 效果是一样的
 */
@WebFilter(urlPatterns = "/*", filterName = "logFilter2")
public class LogCostFilter2 implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("获取到的方法名是"+method);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
 
    }
}