package com.jbwang.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.jbwang.concurrency.annoations.NotThreadSafe;

import java.util.Map;

/**
 * @author: jbwang0106
 * @description: final 修饰变量
 * @create: 2018-06-07 22:48
 **/
@NotThreadSafe
public class ImmutableEaxmple01 {

    private final static Integer a = 1;
    private final static String b = "b";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        //a = 2;
        //b = "d";
        //map = Maps.newHashMap();
        map.put(7, 8);
        System.out.println(map);
    }
}
