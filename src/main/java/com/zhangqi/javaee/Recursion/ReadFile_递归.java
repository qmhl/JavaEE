package com.zhangqi.javaee.Recursion;

import java.io.File;
import java.util.ArrayList;

public class ReadFile_递归 {
    public static void main(String[] args) {
        // 封装路径
         File file = new File("E:\\work\\简历模板");
        getFile(file);

    }

    private static void getFile(File file) {
        ArrayList<Object> list = new ArrayList<>();

        File[] files = file.listFiles();
        for (File file1 : files) {
//            System.out.println(file1);
            list.add(file1);
            //  满足条件 如果是文件是个目录的话 继续递归遍历
            if (file1.isDirectory()) {
                getFile(file1);
            }
        }

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
