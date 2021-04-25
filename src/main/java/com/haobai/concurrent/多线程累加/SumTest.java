package com.haobai.concurrent.多线程累加;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author haobai
 * @description: 1、起 5个线程，并发对1-n之间的数字进行求和，并打印结果。（要求5个线程全部计算完再一次性汇总）
 * @date 2021/3/1 14:08
 */
public class SumTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new SumTest().sum();
    }

    public void sum() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 100, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(1000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Task task = new Task(i * 2000 + 1, (i + 1) * 2000);
            Future<Integer> submit = poolExecutor.submit(task);
            list.add(submit);
        }
        Integer sums = 0;
        for (int i = 0; i < 5; i++) {
            Integer result = (Integer) list.get(i).get();
            System.out.println("线程i:" + i + " 的计算结果为" + result);
            sums += result;
        }
        System.out.println(sums);
    }
}
