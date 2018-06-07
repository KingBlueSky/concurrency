package com.jbwang.concurrency.example.singleton;

import com.jbwang.concurrency.annoations.ThreadSafe;

/**
 * @author: jbwang0106
 * @description: 饿汉式的单例模式
 * @create: 2018-06-07 22:07
 **/

@ThreadSafe
public class SingletonExample06 {

    private SingletonExample06() {}

    //要注意静态域和静态方法的先后顺序
    private static SingletonExample06 instance = null;

    static {
        instance = new SingletonExample06();
    }

    public static SingletonExample06 getInstance() {
        return instance;
    }
}
