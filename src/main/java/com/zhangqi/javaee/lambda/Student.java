package com.zhangqi.javaee.lambda;

public class Student {
    private int age;
    private String username;
    private String code;


    public Student(int age, String username, String code) {
        this.age = age;
        this.username = username;
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
