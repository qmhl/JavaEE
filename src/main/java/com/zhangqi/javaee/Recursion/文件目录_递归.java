package com.zhangqi.javaee.Recursion;

import java.io.File;

public class 文件目录_递归 {
    public static void main(String[] args) {
        File f = new File("E:\\work\\简历模板");
        printFile(f, 0);
    }

    static void printFile(File file, int level) {
        //  第一级目录不用打印空格
//        for (int i = 0; i < level; i++) {
//            System.out.print("  ");
//        }
        System.out.println(file.getName());

        //如果是目录
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            //遍历目录下的全部文件
            for (File temp : files) {
                printFile(temp, level + 1);
            }

        }
    }

}
