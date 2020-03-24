package com.zhangqi.javaee.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static String msg = null ;  // 设置一个字符串
    public static void main(String[] args) throws Exception {
//        // 获得当前的线程操作类
//        Thread mainThread = Thread.currentThread();
//        new Thread(()->{
//            try {
//                msg = "www.baidu.com" ;
//                System.out.println("子线程："+msg);
//            } finally {  // 解锁关起状态
//                LockSupport.unpark(mainThread);
//            }
//        }) .start();
//        LockSupport.park(mainThread);
//        System.out.println("********** 主线程执行完毕,msg="+msg);



        // 获得当前的线程操作类
        Thread mainThread = Thread.currentThread();
        new Thread(()->{
            try {
                msg = "www.baidu.com" ;
                System.out.println("子线程："+msg);
            } finally {  // 解锁关起状态
            }
        }) .start();
        System.out.println("********** 主线程执行完毕,msg="+msg);


        // 2个线程全部执行完毕后可以继续执行
        CountDownLatch cdl = new CountDownLatch(2) ;
        for (int x = 0; x < 2; x++) {
            new Thread(() -> {
                System.out.println("【"
                        +Thread.currentThread().getName()
                        +"】线程应用执行完毕。");
                cdl.countDown(); // 减少等待的线程个数
            },"线程对象-" + x).start();
        }
        cdl.await();   // 等待计数的结束（个数0）
        System.out.println("【*** 主线程 ***】所有的程序执行完毕。");



        // 当凑够2个线程就进行触发
        CyclicBarrier cb = new CyclicBarrier(2);
        for (int x = 0; x < 3; x++) {
            int sec = x ;
            new Thread(() -> {
                System.out.println("【"
                        + Thread.currentThread().getName()
                        + " - 等待开始】");
                try {
                    TimeUnit.SECONDS.sleep(sec);
                    cb.await(); // 等待处理
                } catch (Exception e) { e.printStackTrace(); }
                System.out.println("【"
                        + Thread.currentThread().getName()
                        + " - 等待结束】");
            }, "娱乐者-" + x).start();
        }

    }
}
