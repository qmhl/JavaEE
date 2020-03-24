package com.zhangqi.javaee.lambda;

import java.util.HashMap;

public class Optional {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "we");
        map.put("2", "zz");
//        System.out.println(Optional.ofNullable(map).map(m -> m.get("1")).orElse("嘻嘻"));
    }
}
