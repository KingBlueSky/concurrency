package com.jbwang.concurrency.example.publish;

import com.jbwang.concurrency.annoations.NotRecommend;
import com.jbwang.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: jbwang0106
 * @description: 对象逃逸
 * @create: 2018-06-07 21:55
 **/
@NotThreadSafe
@NotRecommend
@Slf4j
public class Escape {

    private int thisEscape = 0;

    public Escape() {
        new InnerEscape();
    }

    private class InnerEscape {
        public InnerEscape() {
            //thisEscape可能在还没有被初始化完就被引用
            log.info("escape: {}", Escape.this.thisEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
