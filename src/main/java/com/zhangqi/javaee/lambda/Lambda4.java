package com.zhangqi.javaee.lambda;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda4 {

    public static void main(String[] args) {

        Student student1 = new Student(200, "yangtao", "1");
        Student student2 = new Student(220, "yangtao", "1");
        Student student3 = new Student(500, "yangtao", "2");
        Student student4 = new Student(504, "yangtao", "2");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        //单一分组条件,根据code
        Map<String, List<Student>> singleMap = studentList.stream().collect(Collectors.groupingBy(Student::getCode));
        //{1=[Student{age=200, username='yangtao', code='1'}, Student{age=220, username='yangtao', code='1'}],
        // 2=[Student{age=500, username='yangtao', code='2'}, Student{age=504, username='yangtao', code='2'}]}

        System.out.println(singleMap);
        //组合分组条件

        Map<String, List<Student>> complexMap = studentList.stream().collect(Collectors.groupingBy(e -> fetchGroupKey(e)));
        List<Student> studentList1 = complexMap.get("yangtao+1");
        List<Student> studentList2 = complexMap.get("yangtao+2");
        System.out.println(complexMap.toString());
//           {yangtao+2=[Student{age=500, username='yangtao', code='2'}, Student{age=504, username='yangtao', code='2'}], yangtao+1=[Student{age=200, username='yangtao', code='1'}, Student{age=220, username='yangtao', code='1'}]}

        System.out.println(studentList1);
        System.out.println(studentList2);
        //[Student{age=200, username='yangtao', code='1'}, Student{age=220, username='yangtao', code='1'}]
        //[Student{age=500, username='yangtao', code='2'}, Student{age=504, username='yangtao', code='2'}]


        Person person = new Person();
        Class<? extends Person> aClass = person.getClass();
        String simpleName = aClass.getSimpleName();
        System.out.println(aClass);
        System.out.println(simpleName);
}

    private static String fetchGroupKey(Student student) {
        return student.getUsername() + "+" + student.getCode();
    }






}
