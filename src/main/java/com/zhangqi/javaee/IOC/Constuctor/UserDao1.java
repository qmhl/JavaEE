package com.zhangqi.javaee.IOC.Constuctor;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过@Component  注册到ioc容器中
 */
@Component
public class UserDao1 {

    public Map<String,String> getUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","李保柱");
        map.put("age","18");
        map.put("sex","男");
        return map;
    }
}
