package com.jbwang.concurrency.example.synccontainer;

import java.util.Arrays;
import java.util.List;

/**
 * @author: jbwang0106
 * @description: array
 * @create: 2018-06-09 18:09
 **/
public class ArrayListExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> subList = list.subList(0, 4);
        subList.add(5);
        subList.add(5);
        subList.add(5);
    }
}
