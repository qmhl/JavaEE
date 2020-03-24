package com.zhangqi.javaee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JavaeeApplicationTests {

    @Test
    public void test9() {
        String str = "Hello";
        Optional<String> opt = Optional.ofNullable(str);
        //判断是否是纯字母单词，如果是，转为大写，否则保持不变
        String result = opt.filter(s -> s.matches("[a-zA-Z]+")).
                map(s -> s.toLowerCase()).
                orElse(str);
        System.out.println(result);
    }


    @Test
    public void test8() {
        String str = null;
        Optional<String> opt = Optional.ofNullable(str);
        String string = opt.orElseThrow(() -> new RuntimeException("值不存在"));
        System.out.println(string);
    }


    @Test
    public void test7() {
        String str = null;
        Optional<String> opt = Optional.ofNullable(str);
        String string = opt.orElseGet(String::new);
        System.out.println(string);
    }

    @Test
    public void test6() {
        String str = null;
        Optional<String> opt = Optional.ofNullable(str);
        String string = opt.orElse("atguigu");
        System.out.println(string);
    }

    @Test
    public void test5() {
        String str = null;
        Optional<String> opt = Optional.ofNullable(str);
        System.out.println(opt.get());//java.util.NoSuchElementException: No value present
    }

    @Test
    public void test4() {
        String str = "hello";
        Optional<String> opt = Optional.of(str);

        String string = opt.get();
        System.out.println(string);
    }


    @Test
    public void test3() {
        String str = null;
        Optional<String> opt = Optional.ofNullable(str);

        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");

        Optional<String> longest = names
                .filter(name -> name.startsWith("D"))
                .findFirst();

//        longest.ifPresent(name -> {
//            String s = name.toUpperCase();
//            System.out.println("The longest name is " + s);
//        });
        Optional<String> s1 = longest.map(s -> s.toUpperCase());
        if(s1.isPresent()){
            System.out.println(s1.get());

        }
    }

    @Test
    public void test2() {
        String str = "hello";
        Optional<String> opt = Optional.of(str);
        System.out.println(opt);
    }

    @Test
    public void test11() {
        int i =0;
        int j =0;

        int a = i++;
        int b = ++j;
        System.out.println(a+"========="+i);
        System.out.println(b+"========="+j);


    }

    @Test
    public void whenCheckIfPresent_thenOk() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> opt = Optional.ofNullable(user);
        assertTrue(opt.isPresent());

        Assertions.assertEquals(user.getName(), opt.get().getName());
    }

}
