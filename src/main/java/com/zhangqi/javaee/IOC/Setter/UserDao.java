package com.zhangqi.javaee.IOC.Setter;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    public Map<String,String> getUser(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","李保柱");
        map.put("age","18");
        map.put("sex","男");
        return map;
    }
}
