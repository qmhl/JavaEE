package com.zhangqi.javaee.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印
 */
public class 三个线程交替顺序打印ABC_1 {

    //使用Lock 和 state标志
    private static Lock lock=new ReentrantLock();
    private static int state=0;//通过state的值来确定是哪个线程打印

    static class ThreadA extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==0){// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                        System.out.print("A");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==1){
                        System.out.print("B");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }


    static class ThreadC extends Thread{
        @Override
        public void run(){
            for (int i = 0; i <10 ; ) {
                try{
                    lock.lock();
                    while(state%3==2){
                        System.out.print("C");
                        state++;
                        i++;
                    }
                }finally{
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
