package com.zhangqi.javaee.IO;

public class Student {
    private String name = "zhangqi";
    private String pwd = "123456";

    public Student(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
        System.out.println(this.name+"====="+this.pwd);
    }

    public  String getValue(){
        return  name;
    }

}
