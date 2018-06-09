package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: jbwang0106
 * @description: 如果获取不到许可则丢弃任务
 * @create: 2018-06-09 18:58
 **/
@Slf4j
public class SemaphoreExample3 {

    private static final int threadCount = 20;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.submit(() -> {
                try {
                    if (semaphore.tryAcquire()) {
                        test(threadNum);
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    log.error("exception: ", e);
                }
            });
        }

        executorService.shutdown();

    }

    private static void test(int threadNum) throws InterruptedException {
        //Thread.sleep(1);
        log.info("threadNum, {}", threadNum);
    }
}
