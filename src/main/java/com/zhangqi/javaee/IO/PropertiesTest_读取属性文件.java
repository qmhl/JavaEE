package com.zhangqi.javaee.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest_读取属性文件 {
    public static void main(String[] args) throws IOException {
        // 创建属性集对象
        Properties pro = new Properties();
        // 加载文本中信息到属性集
        pro.load(new FileInputStream("Properties.txt"));
        // 遍历集合并打印
        Set<String> strings = pro.stringPropertyNames();
        System.out.println(strings);
        System.out.println(pro);

        HashMap<String, String> map = new HashMap<String, String>();
        for (String key : strings ) {
            map.put(key,pro.getProperty(key));
            System.out.println(key+" -- "+pro.getProperty(key));
        }
        System.out.println(map);


    }
}
