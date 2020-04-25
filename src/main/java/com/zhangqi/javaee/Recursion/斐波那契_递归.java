package com.zhangqi.javaee.Recursion;

public class 斐波那契_递归 {

    public static void main(String[] args) {

        //斐波那契数列：1，1，2，3，5，8 ......
        System.out.print( f(6) );//输出数列的第几位
    }

    public static int f(int n){
        if (n ==1 || n ==2) {
            return 1;
        }
        return f(n-1)+f(n-2);
    }
}
