package com.zhangqi.javaee.thread.Callable;

import java.util.concurrent.Callable;

public class MyCallable<String> implements Callable<String> {
 
	private int tickt=10;
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		String result;
		while(tickt>0) {
			System.out.println("票还剩余："+tickt);
			tickt--;
		}
		result=(String) "票已卖光";
		return result;
	}
 
}
