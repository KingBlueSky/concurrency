package com.jbwang.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.jbwang.concurrency.annoations.ThreadSafe;

/**
 * @author: jbwang0106
 * @description: final 修饰变量
 * @create: 2018-06-07 22:48
 **/
@ThreadSafe
public class ImmutableEaxmple03 {

    private static final ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private static final ImmutableSet<Integer> set = ImmutableSet.copyOf(list);

    private static final ImmutableMap<String, Object> map = ImmutableMap.<String, Object>builder()
            .put("1", "one")
            .put("2", "two")
            .build();

    public static void main(String[] args) {
        //不能进行元素的添加
        list.add(4);
        set.add(4);
        map.put("3", "three");
    }
}
