package com.zhangqi.javaee.IOC.Setter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
    private  UserDao userDao;



    @RequestMapping("/get")
    public Map<String, String> getUser() {
        return userDao.getUser();
    }
}
