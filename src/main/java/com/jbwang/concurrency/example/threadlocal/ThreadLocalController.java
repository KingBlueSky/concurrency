package com.jbwang.concurrency.example.threadlocal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jbwang0106
 * @description: thread local controller
 * @create: 2018-06-08 23:22
 **/

@RestController
@RequestMapping("threadlocal")
public class ThreadLocalController {

    @GetMapping("test")
    public Long test() {
        return RequestHolder.get();
    }
}
