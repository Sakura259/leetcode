package com.haobai.concurrent.多线程累加;

import java.util.concurrent.Callable;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 14:02
 */
public class Task implements Callable {

    private Integer start;

    private Integer end;

    private Integer sum;

    public Task(Integer start, Integer end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
