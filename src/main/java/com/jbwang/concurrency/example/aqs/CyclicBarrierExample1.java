package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: jbwang0106
 * @description: countDownLatch
 * @create: 2018-06-09 18:58
 **/
@Slf4j
public class CyclicBarrierExample1 {

    final static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception: ", e);
                }
            });
        }

    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("read, {}", threadNum);
        int await = cyclicBarrier.await();
        System.out.println(await + " " + threadNum);
        log.info("continue, {}", threadNum);

    }
}
