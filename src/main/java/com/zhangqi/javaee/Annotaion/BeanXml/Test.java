package com.zhangqi.javaee.Annotaion.BeanXml;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames) {
            System.out.println(beanName);
        }

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Student stu = (Student) context.getBean("stu");
//        System.out.println(stu);
    }
}
