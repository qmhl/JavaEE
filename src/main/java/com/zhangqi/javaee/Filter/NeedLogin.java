package com.zhangqi.javaee.Filter;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedLogin {


    // 自定义 NeedLogin 注解，标识需要登录校验的方法
    /**
     * 自定义注解需要增加 @Target 和 @Retention 注解
     *      @Target 设置注解的使用范围
     *          TYPE        类
     *          FIELD       属性
     *          METHOD      方法
     *          PARAMETER   参数
     *
     *     @Retention 设置注解的有效范围
     *          SOURCE      编码
     *          CLASS       编译
     *          RUNTIME     运行
     */

}