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
public class SingletonExample07 {

    private SingletonExample07() {}

    public static SingletonExample07 getInstance() {
        return Singleton.INSTANCE.getSingletonExample07();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample07 singletonExample07;

        //jvm保证类的初始化是线程安全的
        Singleton () {
            singletonExample07 = new SingletonExample07();
        }

        public SingletonExample07 getSingletonExample07() {
            return singletonExample07;
        }
    }
}
