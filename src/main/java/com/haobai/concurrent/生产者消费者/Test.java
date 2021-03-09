package com.haobai.concurrent.生产者消费者;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 15:46
 */
public class Test {

    public static void main(String[] args) {
        Resource resource = new Resource(new ConcurrentHashMap<>(100), 0);
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        Producer producer = new Producer(lock, notFull, notEmpty, "生产者1", resource);

        Consumer consumer1 = new Consumer(lock, notFull, notEmpty, "消费者1", resource);
        Consumer consumer2 = new Consumer(lock, notFull, notEmpty, "消费者2", resource);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
