package com.jbwang.concurrency.example.count;

import com.jbwang.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: jbwang0106
 * @description: 并发测试
 * @create: 2018-06-05 21:55
 **/

@Slf4j
@NotThreadSafe
public class ConcurrencyExample01 {

    //请求总数
    private static int totalCount = 5000;

    //同时请求数
    private static int threadCount = 200;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量
        final Semaphore semaphore = new Semaphore(threadCount);
        //定义闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(totalCount);
        for (int i = 0; i < totalCount; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception: " + e.getStackTrace());
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        log.info("count: " + count);
        executorService.shutdown();
    }

    private static void add() {
        count ++;
    }


}
