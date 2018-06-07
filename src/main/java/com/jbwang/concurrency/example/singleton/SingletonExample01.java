package com.jbwang.concurrency.example.singleton;

import com.jbwang.concurrency.annoations.NotThreadSafe;

/**
 * @author: jbwang0106
 * @description: 懒汉式的单例模式
 * @create: 2018-06-07 22:07
 **/

@NotThreadSafe
public class SingletonExample01 {

    private SingletonExample01() {}

    private static SingletonExample01 instance = null;

    public static SingletonExample01 getInstance() {
        if (null == instance) {
            instance = new SingletonExample01();
        }
        return instance;
    }
}
