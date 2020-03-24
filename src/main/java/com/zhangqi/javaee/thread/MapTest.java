package com.zhangqi.javaee.thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapTest {
    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("s","nihao");
        map.put("ds","hello");
        map.put("ts","welcome");
        map.put("zs","welcome");
        map.put("as","finish");
        System.out.println(map);
        ConcurrentSkipListMap sortmap = new ConcurrentSkipListMap(map);


        System.out.println(sortmap);
    }
}
