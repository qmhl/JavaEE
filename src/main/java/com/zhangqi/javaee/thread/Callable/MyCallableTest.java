package com.zhangqi.javaee.thread.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //  自定义callable接口
        MyCallable<String> mc = new MyCallable<String>();
        //  FutureTask
        FutureTask<String> ft = new FutureTask<String>(mc);
        new Thread(ft).start();
        //  获取callable接口  的返回值
        String result = ft.get();
        //  返回结果是 ： 票已卖光
        System.out.println(result);
    }

}
