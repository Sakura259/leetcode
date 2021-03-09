package com.haobai.concurrent.生产者消费者;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 14:57
 */
@Data
@AllArgsConstructor
public class Consumer implements Runnable {

    private ReentrantLock lock;

    private Condition notFull;

    private Condition notEmpty;

    private String consumerName;

    private Resource resource;


    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                ConcurrentHashMap<Integer, Integer> map = resource.getMap();
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                if (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> next = iterator.next();
                    iterator.remove();
                    System.out.println("消费者:" + consumerName + "消费了key：" + next.getKey() + "消费了value：" + next.getValue());
                    notFull.signal();
                } else {
                    notEmpty.await();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }

    }

}
