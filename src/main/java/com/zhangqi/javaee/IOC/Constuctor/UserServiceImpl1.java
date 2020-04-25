package com.zhangqi.javaee.IOC.Constuctor;

import org.springframework.stereotype.Component;

import java.util.Map;



/**
 * 通过@Component  注册到ioc容器中
 */
@Component
public class UserServiceImpl1 implements UserService1 {

    private UserDao1 userDao1;
    //  通过构造函数注入
    public UserServiceImpl1(UserDao1 userDao1) {
        this.userDao1 = userDao1;
    }

    @Override
    public Map<String, String> getUser() {
        return userDao1.getUser();
    }
}
