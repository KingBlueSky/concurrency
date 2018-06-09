package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: jbwang0106
 * @description: countDownLatch
 * @create: 2018-06-09 18:58
 **/
@Slf4j
public class CountDownLatchExample1 {

    private static final int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.submit(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("exception: ", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();
        log.info("finish");
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("threadNum, {}", threadNum);
        Thread.sleep(100);
    }
}
