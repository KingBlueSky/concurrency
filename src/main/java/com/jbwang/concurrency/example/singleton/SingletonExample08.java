package com.jbwang.concurrency.example.singleton;

import com.jbwang.concurrency.annoations.Recommend;
import com.jbwang.concurrency.annoations.ThreadSafe;

/**
 * @author: jbwang0106
 * @description: 饿汉式的单例模式
 * @create: 2018-06-07 22:07
 **/

@ThreadSafe
@Recommend
public class SingletonExample08 {

    private SingletonExample08() {}

    public static SingletonExample08 getInstance() {
        return Singleton.instance;
    }

    private static class Singleton {
        public static SingletonExample08 instance = new SingletonExample08();
    }
}
