package com.zhangqi.javaee.IO;

import java.io.*;

public class BufferedInputStream_字节缓冲流 {

    public static void main(String[] args) throws FileNotFoundException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try {
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Properties.txt"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Properties_copy.txt"));

//            // 读写数据   一个字节字节的读
//            int b;
//            while ((b = bis.read()) != -1) {
//                bos.write(b);
//            }

            //  读写数据 字节数组的读
            int len;
            byte[] bytes = new byte[8*1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0 , len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间:"+(end - start)+" 毫秒");
    }
}
