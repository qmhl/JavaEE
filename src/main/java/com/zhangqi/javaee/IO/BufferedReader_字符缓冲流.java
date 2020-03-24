package com.zhangqi.javaee.IO;

import java.io.*;
import java.util.HashMap;

public class BufferedReader_字符缓冲流 {

    public static void main(String[] args) throws IOException {
        /**
         * 一行一行的读取文件
         */
        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("Properties.txt"));
        // 定义字符串,保存读取的一行文字
        String line = null;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine()) != null) {
            System.out.print(line);
            System.out.println("------");
        }
        // 释放资源
        br.close();

        /**
         * 一行一行的写文件
         */


        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        // 写出数据
        bw.write("哥");
        // 写出换行
        bw.newLine();
        bw.write("敢");
        bw.newLine();
        bw.write("摸屎");
        bw.newLine();
        bw.write("你敢吗？");
        bw.newLine();
        // 释放资源
        bw.close();


        /**
         * 一行一行的读取文件成 map
         */

        HashMap<String, String> map = new HashMap<>();
        //  读取属性文件
        BufferedReader br1 = new BufferedReader(new FileReader(new File("a.txt")));
        //  写文件
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("b.txt")));

        //  将文件 读成map
        String line1 = null;
        while ((line1 = br1.readLine()) != null) {
            //  解析每行的文本

            String[] split = line1.trim().split("\\.");
            String key =split[0];
            String value =split[1];
            map.put(key, value);
        }
        // 释放资源
        br1.close();

        //  将map遍历

        for (int i = 1; i <map.size() ; i++) {
            String key = String.valueOf(i);
            String value = map.get(key);
            bw1.write(i+"."+value);
            //  写出换行
            bw1.newLine();
        }

        // 释放资源
        bw1.close();

    }
}
