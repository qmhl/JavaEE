package com.zhangqi.javaee.continueTest;

public class ContinueDemo {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            //  当i == 2 时候 就不输出，继续进行下一个for循环
            if(i==2){
                continue;
            }
            System.out.println(i);
        }
        //=======================================================

        for (int i = 0; i < 10; i++) {
            //  当i == 2 时候 就直接跳出所有for循环
            if (i == 2) {
                break;
            }
            System.out.println(i);
        }

        System.out.println("break运行结束了");

        //=======================================================
        for (int i = 0; i < 10; i++) {
            //  当i == 2 时候 就直接返回 sout的内容都不会输出
            if (i == 2) {
                return;
            }
            System.out.println(i);
        }
        System.out.println("return运行结束了，不会进行输出");



    }


}
