package com.jbwang.concurrency.example.immutable;

import com.jbwang.concurrency.annoations.ThreadSafe;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: jbwang0106
 * @description: final 修饰变量
 * @create: 2018-06-07 22:48
 **/
@ThreadSafe
public class ImmutableEaxmple02 {

    private static final List<String> list = Collections.unmodifiableList(Arrays.asList("1", "2", "3"));

    public static void main(String[] args) {
        //不能进行元素的添加
        list.add("4");
    }
}
