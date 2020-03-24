package com.zhangqi.javaee.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda1 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("多线程启动");
        }).start();


        //********************************************
        System.out.println("==========================");

        // 本来年龄乱序的对象数组
        Person[] array = {
                new Person("古力娜扎", 19),
                new Person("迪丽热巴", 18),
                new Person("马尔扎哈", 20)};

        // 匿名内部类
//        Comparator<Person> comp = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        };
//        Arrays.sort(array, comp); // 第二个参数为排序规则，即Comparator接口实例
//
//        for (Person person : array) {
//            System.out.println(person.toString());
//        }


        //Lambda写法：

        Arrays.sort(array, (Person p1, Person p2) -> {
            return p2.getAge() - p1.getAge();
        });

        for (Person person : array) {
            System.out.println(person.toString());
        }


        // Java 8之前：
//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        for (Object feature : features) {
//            System.out.println(feature);
//        }


        // Java 8之后：
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
//
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");

        filter(languages, startsWithJ);
//
//        System.out.println("Languages which ends with a ");
//        filter(languages, (str)->str.endsWith("a"));
//
//        System.out.println("Print all languages :");
//        filter(languages, (str)->true);
//
//        System.out.println("Print no language : ");
//        filter(languages, (str)->false);
//
//        System.out.println("Print language whose length greater than 4:");
//        filter(languages, (str)->str.length() > 4);

//        Predicate<String> startsWithJ = (n) -> n.startsWith("J");


// 不使用lambda表达式为每个订单加上12%的税
//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            System.out.println(price);
//        }

        // 使用lambda表达式
        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        costBeforeTax.stream().map((cost) -> 300).forEach(System.out::println);
        Object collect = costBeforeTax.stream().map(cost -> 300).collect(Collectors.toList());
        System.out.println("map处理之后的集合"+collect);



        // 创建一个字符串列表，每个字符串长度大于2
        List strList = Arrays.asList("Lambdas", "thod", "Stream API", "Date and Time API");
        Predicate<String> predicate = (x) -> x.length()>7;

//        List<String> filtered = (List<String>) strList.stream().filter(predicate).collect(Collectors.toList());
//        System.out.printf(" filtered list : %s %n", filtered);

        List<String> filtered;
        filtered = (List<String>) strList.stream().filter((Object n) -> {
            return !n.equals("thod");
        }).collect(Collectors.toList());
        System.out.printf(" filtered list : %s %n", filtered);


        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

    }

    // 更好的办法
    public static void filter (List names, Predicate condition){
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }
}
