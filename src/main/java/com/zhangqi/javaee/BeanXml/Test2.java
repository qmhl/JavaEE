package com.zhangqi.javaee.BeanXml;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2
{
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationcontext = new ClassPathXmlApplicationContext("beans.xml");
        Student person = (Student) applicationcontext.getBean("student");
        System.out.println(person.toString());


    }
}
