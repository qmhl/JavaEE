package com.zhangqi.javaee.Annotaion.BeanXml;

public class Student {
    private String name = "zhangqi";
    private String pwd = "123456";
    private String age = "12";

    public Student(String name, String pwd,String age) {
        this.name = name;
        this.pwd = pwd;
        this.age =age;
        System.out.println(this.name+"====="+this.pwd);
    }


    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{name"+name+"====="+pwd+"}";
    }
}
