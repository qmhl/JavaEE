package com.zhangqi.javaee.IO;

import java.io.*;

public class InputStreamReader_字节流到字符流的桥梁 {

    public static void main(String[] args) throws IOException {
        // 定义文件路径,文件为gbk编码
        String FileName = "C:\\A.txt";
        // 创建流对象,默认UTF8编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(FileName));
        // 创建流对象,指定GBK编码
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream(FileName) , "GBK");
        // 定义变量,保存字符
        int read;
        // 使用默认编码字符流读取,乱码
        while ((read = isr.read()) != -1) {
            System.out.print((char)read); // �����ʺ
        }
        isr.close();

        // 使用指定编码字符流读取,正常解析
        while ((read = isr2.read()) != -1) {
            System.out.print((char)read);// 哥敢摸屎
        }
        isr2.close();
    }
}
