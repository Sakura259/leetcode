package com.test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author haobai
 * @description:
 * @date 2021/3/26 19:27
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(48, 48, 100, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(100));
        List<Kefu> list = new ArrayList<>(48);
        for (int i = 0; i < 48; i++) {
            Kefu kefu = new Kefu(i);
            list.add(kefu);
        }
        while (true) {
            Customer customer = new Customer(16, "1号");
            int index = customer.getUserId() % 48;
            Kefu kefu = list.get(index);
            kefu.offer(customer);
            pool.execute(kefu);
        }
    }
}
