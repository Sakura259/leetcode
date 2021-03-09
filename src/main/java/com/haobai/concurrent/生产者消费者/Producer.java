package com.haobai.concurrent.生产者消费者;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 14:56
 */
@Data
@AllArgsConstructor
public class Producer implements Runnable {

    private ReentrantLock lock;

    private Condition notFull;

    private Condition notEmpty;

    private String ProducerName;

    private Resource resource;

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                ConcurrentHashMap<Integer, Integer> map = resource.getMap();
                Integer target = resource.getTarget();
                if (target < 10000) {
                    if (map.keySet().size() < 10) {
                        map.put(target, target);
                        System.out.println("生产者:" + ProducerName + "生产了key：" + target + "生产了value：" + target);
                        resource.setTarget(++target);
                        notEmpty.signalAll();
                    } else {
                        notFull.await();
                    }
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }

    }
}
