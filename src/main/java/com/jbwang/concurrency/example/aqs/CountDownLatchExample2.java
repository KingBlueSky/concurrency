package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: jbwang0106
 * @description: countDownLatch
 * @create: 2018-06-09 18:58
 **/
@Slf4j
public class CountDownLatchExample2 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.submit(() -> {
                test(threadNum);
                countDownLatch.countDown();

            });
        }

        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("finish");
    }

    private static void test(int threadNum) {
        log.info("threadNum, {}", threadNum);
    }
}
