package com.jbwang.concurrency.example.threadlocal;

/**
 * @author: jbwang0106
 * @description: threadlocal use
 * @create: 2018-06-08 22:57
 **/
public class RequestHolder {

    private static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long get() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
