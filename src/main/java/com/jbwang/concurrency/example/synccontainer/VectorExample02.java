package com.jbwang.concurrency.example.synccontainer;

import com.jbwang.concurrency.annoations.NotThreadSafe;

import java.util.Vector;

/**
 * @author: jbwang0106
 * @description: list
 * @create: 2018-06-09 17:27
 **/

@NotThreadSafe
public class VectorExample02 {

    //同时使用remove和get会存在线程安全问题
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    vector.get(i);
                }
            });

            thread1.start();
            thread2.start();
        }


    }
}
