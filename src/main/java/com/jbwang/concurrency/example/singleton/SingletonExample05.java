package com.jbwang.concurrency.example.singleton;

import com.jbwang.concurrency.annoations.ThreadSafe;

/**
 * @author: jbwang0106
 * @description: 懒汉式的单例模式
 * 双重锁检测机制
 * @create: 2018-06-07 22:07
 **/

@ThreadSafe
public class SingletonExample05 {

    private SingletonExample05() {}

    //1. memory = allocate() 分配内存空间
    //2. ctorInstance() 初始化对象
    //3. instance = memory 设置instance指向刚分配的内存空间

    private static volatile SingletonExample05 instance = null;

    public static SingletonExample05 getInstance() {
        if (null == instance) {
            synchronized (SingletonExample05.class) {
                if (null == instance) {
                    instance = new SingletonExample05();
                }
            }
        }
        return instance;
    }
}
