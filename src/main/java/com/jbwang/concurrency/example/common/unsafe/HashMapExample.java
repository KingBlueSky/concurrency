package com.jbwang.concurrency.example.common.unsafe;

import com.jbwang.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: jbwang0106
 * @description: list
 * @create: 2018-06-09 17:27
 **/

@Slf4j
@NotThreadSafe
public class HashMapExample {

    //请求总数
    private static int totalCount = 5000;

    //同时请求数
    private static int threadCount = 200;

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        //定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量
        final Semaphore semaphore = new Semaphore(threadCount);
        //定义闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(totalCount);
        for (int i = 0; i < totalCount; i++) {
            final int count = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception: " + e.getStackTrace());
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        log.info("count: " + map.size());
        executorService.shutdown();
    }

    private static void add(int i) {
        map.put(i, i);
    }
}
