package com.zhangqi.javaee.RateLimiter;

import java.util.concurrent.Semaphore;

public class SemaphoreServiceTask implements Runnable{

    private static Semaphore semphore = new Semaphore(3);

    private String serviceName;

    SemaphoreServiceTask(String serviceName){
        this.serviceName = serviceName;
    }
    @Override
    public void run(){
        if(semphore.getQueueLength()>10){
            System.out.println("当前等待排队的任务数大于10，请稍候再试...");
            return;
        }
        try {
            //  相当于获取锁
            /**
             * 在 semaphore.acquire() 和 semaphore.release()之间的代码，
             * 表示同一时刻只允许制定个数的线程进入，
             * 因为semaphore的构造方法是2，则同一时刻只允许2个线程进入，其他线程等待。
             * */
            semphore.acquire();
            System.out.println("Thread " + serviceName + " is working");
            Thread.sleep(1000);
            System.out.println("Thread " + serviceName + " is over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semphore.release();
        }

    }
}
