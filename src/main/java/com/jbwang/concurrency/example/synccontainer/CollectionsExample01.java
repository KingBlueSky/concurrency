package com.jbwang.concurrency.example.synccontainer;

import com.google.common.collect.Lists;
import com.jbwang.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
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
@ThreadSafe
public class CollectionsExample01 {

    //请求总数
    private static int totalCount = 5000;

    //同时请求数
    private static int threadCount = 200;

    private static List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

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
        log.info("count: " + list.size());
        executorService.shutdown();
    }

    private static void add(int i) {
        list.add(i);
    }
}
