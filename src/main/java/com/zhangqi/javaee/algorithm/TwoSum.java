package com.zhangqi.javaee.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums ={2,7,5,6,4,3,7};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(nums));


        ArrayList<int[]> ints1 = twoSum2(nums, 9);
        System.out.println("=======================");
        System.out.println(Arrays.toString(ints1.toArray()));

        int[] ints2 = twoSum3(nums, 9);
        System.out.println("=======================");
        System.out.println(Arrays.toString(ints2));

    }


    //  第一种   只打出第一次满足的角标、、复杂度分析：
    //
    //时间复杂度：O(n^2)
    //对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)
    //空间复杂度：O(1)

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    //  输出所有满足条件的脚本
    public static ArrayList<int[]> twoSum2(int[] nums, int target) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    list.add(new int[] { i, j });
                }
            }
        }
        return list;
    }

    // 第二种方案 两边哈希表
//    复杂度分析：
//
//    时间复杂度：O(n)
//    我们把包含有 n个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
//
//    空间复杂度：O(n)，
//    所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n个元素。

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



}
