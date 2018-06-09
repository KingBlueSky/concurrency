package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: jbwang0106
 * @description: 同时获取多个许可
 * @create: 2018-06-09 18:58
 **/
@Slf4j
public class SemaphoreExample2 {

    private static final int threadCount = 20;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire(3);
                    test(threadNum);
                    semaphore.release(3);
                } catch (InterruptedException e) {
                    log.error("exception: ", e);
                }
            });
        }

        executorService.shutdown();

    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(2000);
        log.info("threadNum, {}", threadNum);
    }
}
