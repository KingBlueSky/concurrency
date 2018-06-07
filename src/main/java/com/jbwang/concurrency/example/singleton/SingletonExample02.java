package com.jbwang.concurrency.example.singleton;

import com.jbwang.concurrency.annoations.ThreadSafe;

/**
 * @author: jbwang0106
 * @description: 饿汉式的单例模式
 * @create: 2018-06-07 22:07
 **/

@ThreadSafe
public class SingletonExample02 {

    private SingletonExample02() {}

    private static SingletonExample02 instance = new SingletonExample02();

    public static SingletonExample02 getInstance() {
        return instance;
    }
}
