package com.zhangqi.javaee.HandlerInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 主要是用来注册拦截器
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  就是把拦截器注入  这里是通过new 注入的
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/intercept");
        super.addInterceptors(registry);
    }
}