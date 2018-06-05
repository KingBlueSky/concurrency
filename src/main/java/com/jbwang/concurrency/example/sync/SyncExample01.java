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
public class SyncExample01 {

    //修改代码块
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 ->: {}", i);
            }
        }
    }

    //修改方法
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 ->:" + i);
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            SyncExample01 syncExample01 = new SyncExample01();
            executorService.submit(() -> syncExample01.test1());
        }
        executorService.shutdown();
    }
}
