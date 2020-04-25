package com.zhangqi.javaee.IOC.Constuctor;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user1")
public class UserController1 {

    private UserService1 userService1;
    //  通过构造函数注入
    public UserController1(UserService1 userService1) {
        this.userService1 = userService1;
    }

    @RequestMapping("/get1")
    public Map<String, String> getUser() {
        return userService1.getUser();
    }
}
