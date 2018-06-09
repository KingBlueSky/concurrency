package com.jbwang.concurrency.example.common.unsafe;

import com.jbwang.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: jbwang0106
 * @description: date format
 * @create: 2018-06-09 17:10
 **/

@NotThreadSafe
@Slf4j
public class DateFormatExample01 {

    //采用局部变量
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    //请求总数
    private static int totalCount = 5000;

    //同时请求数
    private static int threadCount = 200;

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
                    parse();
                    semaphore.release();
                } catch (Exception e) {
                    log.error(e.getStackTrace() + "");
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
    }

    private static void parse() {
        try {
            simpleDateFormat.parse("20180602");
        } catch (Exception e) {
            log.error("parse exception: {}", e.getMessage());
        }
    }
}
