package com.test.test;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/26 19:16
 */
@Data
public class Kefu implements Runnable {

    private Integer id;

    private LinkedList<Customer> queue = new LinkedList<>();

    public Kefu(Integer id) {
        this.id = id;
    }


    @Override
    public void run() {
        int i = 0;
        while (true) {
            while (!queue.isEmpty() && i < 3) {
                Customer poll = queue.poll();
                poll.call();
                i++;
            }
        }
    }

    public void offer(Customer customer) {
        queue.add(customer);
    }
}
