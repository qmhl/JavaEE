package com.zhangqi.javaee.thread;


/**
 * 实例要求：
 *
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 *
 * https://www.cnblogs.com/xiaotao726/p/6493099.html
 */
public class T1T2T3三个线程顺序打印 {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread01();
        Thread th2 = new Thread02();
        Thread th3 = new Thread03();
        th1.start();
        th1.join();
        System.out.println("T1");
        th2.start();
        th2.join();
        System.out.println("T2");
        th3.start();
        th3.join();
        System.out.println("T3");
        System.out.println("------主函数-------");
        //T1
        //T2
        //T3
        //------主函数-------
    }



}


class Thread01 extends Thread{

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread02 extends Thread{
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
class Thread03 extends Thread{
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
