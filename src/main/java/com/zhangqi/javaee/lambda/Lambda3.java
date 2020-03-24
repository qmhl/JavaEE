package com.zhangqi.javaee.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambda3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world","hello world");
        list.stream().flatMap(s -> Stream.of(s.split(" "))).map(String::toUpperCase).forEach(s -> System.out.println(s+"9 "));
//            list.stream().map(String::toUpperCase).flatMap(s -> Stream.of(s.split(","))).forEach(s -> System.out.println(s+"10"));


//        Optional<String> s = Optional.of("input");
//        System.out.println(s.map(Test::getOutput));
//        System.out.println(s.flatMap(Test::getOutputOpt));

    }

//    static Optional<String> getOutputOpt(String input) {
//        return input == null ? Optional.empty() : Optional.of("output for " + input);
//    }
//
//    static String getOutput(String input) {
//        return input == null ? null : "output for " + input;
//    }

}
