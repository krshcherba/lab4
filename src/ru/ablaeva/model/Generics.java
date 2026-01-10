package ru.ablaeva.model;

import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Generics<T,P> {

    public static <T, P> List<P> func(List<T> list1, Function<T, P> mapper) {
        List<P> list2 = new ArrayList<>();

        for (T t : list1) {
            list2.add(mapper.apply(t));
        }

        return list2;
    }

    public static <T> List<T> filter(List<T> list1, Predicate<T> mapper) {
        List<T> list2 = new ArrayList<>();

        for (T t : list1) {
            if (mapper.test(t)) {
                list2.add(t);
            }
        }

        return list2;
    }

    // public static <T> T concat(List<T> list1, Function<List<T>,T> mapper) {
    //     T res = list1.get(0);

    //     for (int i = 1; i < list1.size(); i++) {
    //         res = mapper.apply(res, list1.get(i));
    //     }

    //     return res;
    // }

    public static <T, P> List<P> collect(List<T> list1, Function<T, P> mapper) {
        List<P> list2 = new ArrayList<>();

        for (T t : list1) {
            list2.add(mapper.apply(t));
        }

        return list2;
    }

    public static void main(String[] args) {
        List<String> strings = List.of("qwerty", "asdfg", "zx");
        System.out.println("Массив strings: " + strings);
        System.out.println("N 3-1-1:");
        List<Integer> lengths = func(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println(lengths);

        List<Integer> nums = List.of(1, -3, 7);
        System.out.println("Массив nums: " + nums);
        System.out.println("N 3-1-2:");
        List<Integer> abs = func(nums, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {

                return Math.abs(n); 
            }
        });
        System.out.println(abs);

        List<List<Integer>> nums2 = List.of(List.of(1, 0, 5), List.of(-4, -3, -1), List.of(6, 7, 3));
        System.out.println("Массив nums2: " + nums2);
        System.out.println("N 3-1-3:");
        List<Integer> get_max = func(nums2, new Function<List<Integer>, Integer>() {
            @Override
            public Integer apply(List<Integer> l) {
                int max = Integer.MIN_VALUE;
                for (Integer n: l) {
                    max = (max < n) ? n : max;
                }
                return max;
            }
        });
        System.out.println(get_max);

        System.out.println("N 3-2-1: ");
        Predicate<String> test2 = str -> str.length() < 3;
        List<String> filter_var = filter(strings, test2);
        System.out.println(filter_var);

        System.out.println("N 3-2-2:");
        Predicate<Integer> test3 = n -> n > 0;
        List<Integer> filter_pos_nums = filter(nums, test3);
        System.out.println(filter_pos_nums);

        System.out.println("N 3-2-3: ");
        Predicate<List<Integer>> test4 = list4 -> {
            for (int num : list4) {
                if (num > 0) {
                    return false; 
                }
            }
            return true; 
        };
        List<List<Integer>> filter_unpos_nums = filter(nums2, test4);
        System.out.println(filter_unpos_nums);

        // String concat_res = concat(strings, );
    }
}