package com.zhangqi.javaee.HandlerInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration    //所有的配置类都要在config包下，并增加@Configuration注解
class MyWebMvcConfigurer1  implements WebMvcConfigurer {

    //对于springMvc的自定义的配置都需要通过WebMvcConfigurer接口实现
    //配置拦截器需要
    //1. 注入需要配置的拦截器对象
    //2.实现addInterceptors方法，进行配置
    @Autowired
    private LoginInterceptor1 loginInterceptor1;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  通过    @Autowired  注入的bean
        registry.addInterceptor(loginInterceptor1)    //指定需要配置的拦截器
                .addPathPatterns("/intercept") //指定需要拦截的请求  /**  表示拦截所有
                .excludePathPatterns("/list")  //指定需要排除的请求
               .excludePathPatterns("/login")
                .excludePathPatterns("/toLogin")
                .excludePathPatterns("/toRegister")
                .excludePathPatterns("/*.html");



    }
}