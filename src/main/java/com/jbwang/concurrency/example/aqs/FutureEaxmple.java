package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: jbwang0106
 * @description: future
 * @create: 2018-06-10 20:00
 **/

@Slf4j
public class FutureEaxmple {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {

            log.info("do some thing.....");
            Thread.sleep(5000);
            return "Done";

        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new MyCallable());
        log.info("do some thing in main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("result: " + result);
        service.shutdown();
    }

}
