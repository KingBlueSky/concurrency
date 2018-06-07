package com.jbwang.concurrency.example.publish;

import com.jbwang.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: jbwang0106
 * @description: 不安全的发布对象
 * @create: 2018-06-07 21:50
 **/

@NotThreadSafe
@Slf4j
public class UnsafePublish {

    private String [] status = {"a", "b", "c"};

    public String[] getStatus() {
        return status;
    }

    public static void main(String[] args) {
        //这种发布的对象那个是不安全的，其他线程访问这个对象的话，status的值可能被修改过
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("UnsafePublish: {}", Arrays.asList(unsafePublish.status).toString());
        unsafePublish.getStatus()[0] = "d";
        log.info("UnsafePublish: {}", Arrays.asList(unsafePublish.status).toString());

    }
}
