package com.jbwang.concurrency.example.singleton;

import com.jbwang.concurrency.annoations.NotRecommend;
import com.jbwang.concurrency.annoations.ThreadSafe;

/**
 * @author: jbwang0106
 * @description: 懒汉式的单例模式
 * @create: 2018-06-07 22:07
 **/

@ThreadSafe
@NotRecommend
public class SingletonExample03 {

    private SingletonExample03() {}

    private static SingletonExample03 instance = null;

    public static synchronized SingletonExample03 getInstance() {
        if (null == instance) {
            instance = new SingletonExample03();
        }
        return instance;
    }
}
