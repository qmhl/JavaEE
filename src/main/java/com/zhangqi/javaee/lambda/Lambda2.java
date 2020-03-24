package com.zhangqi.javaee.lambda;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambda2 {

    public static void main(String[] args) {
        List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 6),
                new Fruit("apple", 6),
                new Fruit("banana", 7), new Fruit("banana", 7),
                new Fruit("banana", 7), new Fruit("grape", 8));


        Multimap<String, Integer> multiMap = ArrayListMultimap.create();
        fruitList.forEach(fruit -> multiMap.put(fruit.getName(), fruit.getPrice()));
        System.out.println(multiMap);

        /**
         * ****************************************************
         */

        //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");
//        Map<String, Long> result =items.stream().collect(
//                        Collectors.groupingBy(
//                                Function.identity(), Collectors.counting()
//                        )
//                );
//        System.out.println(result);
        //3 apple, 2 banana, others 1
        List<Item> items2 = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        //  key :name value:是name的个数
        Map<String, Long> counting = items2.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(counting);
        //  key :name value:是qty求和

        Map<String, Integer> sum = items2.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(sum);


        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items2.stream().collect(Collectors.groupingBy(Item::getPrice));
        System.out.println("根绝price分组的结果：===========================");

        System.out.println(groupByPriceMap);
        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items2.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );
        System.out.println("根绝price分组，返回name的set的结果：===========================");

        System.out.println(result);


    }
}
