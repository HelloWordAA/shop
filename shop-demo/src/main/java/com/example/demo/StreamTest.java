package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * yzw
 * 2022/11/26
 * 流式编程
 */
public class StreamTest {
    static int[] nums = new int[]{0, 1, 2, 9, 5, 7, 6,2};

    public static void main(String[] args) {
        List list = Arrays.asList(nums);
        list.stream().sorted(Comparator.comparing(Integer ::intValue)).collect(Collectors.toList());
//        list.stream().forEach(System.out ::println);
        System.out.println(list.get(0));
        IntStream stream = Arrays.stream(nums)
                .distinct()//去重
                .limit(6)
//                .sorted(Comparator.comparing(Integer::intValue).reversed())
//                .collect(Collectors.toList())
//                .filter(n->n==2)//过滤
                ;

//        stream.forEach(System.out::println);
    }
}