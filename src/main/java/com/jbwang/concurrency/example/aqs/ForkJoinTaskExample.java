package com.jbwang.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author: jbwang0106
 * @description: fork join
 * @create: 2018-06-10 20:20
 **/

@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

    private int therad = 2;
    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean coppute = (end - start) <= therad;
        if (coppute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle+1, end);

            leftTask.fork();
            rightTask.fork();

            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = leftResult +rightResult;
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskExample forkJoinTaskExample = new ForkJoinTaskExample(1, 100);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoinTaskExample);
        Integer result = submit.get();
        log.info("result: {}", result);
    }
}
