package com.zhangqi.javaee.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印
 */
public class 三个线程交替顺序打印ABC_4 {
    private AtomicInteger ai = new AtomicInteger(0);
    private static final int MAX_SYC_VALUE = 3 * 10;

    private class RunnableA implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE-1) {
                if (ai.get() % 3 == 0) {
                    System.out.print("A");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableB implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 1) {
                    System.out.print("B");
                    ai.getAndIncrement();
                }
            }

        }
    }

    private class RunnableC implements Runnable {
        public void run() {
            while (ai.get() < MAX_SYC_VALUE) {
                if (ai.get() % 3 == 2) {
                    System.out.println("C");
                    ai.getAndIncrement();
                }
            }

        }
    }


    public static void main(String[] args) {
        三个线程交替顺序打印ABC_4 atomic_ABC = new 三个线程交替顺序打印ABC_4();
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(atomic_ABC.new RunnableA());
        service.execute(atomic_ABC.new RunnableB());
        service.execute(atomic_ABC.new RunnableC());

        service.shutdown();
    }
}
