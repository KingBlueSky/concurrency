package com.jbwang.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: jbwang0106
 * @description: sync test
 * @create: 2018-06-05 23:00
 **/
@Slf4j
public class SyncExample02 {

    //修饰一个类
    public static void test1() {
        synchronized (SyncExample02.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 ->: {}", i);
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 ->:" + i);
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0) {
                executorService.submit(() -> SyncExample02.test1());
            } else {
                executorService.submit(() -> SyncExample02.test2());
            }
        }
        executorService.shutdown();
    }
}
