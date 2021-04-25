package com.haobai.bytedance;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author haobai
 * @description:
 * @date 2021/4/14 21:01
 */
public class 线程依次打印 {
    private static Semaphore intSemaphore = new Semaphore(1);

    private static Semaphore strSemaphore = new Semaphore(0);

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static volatile boolean flag = true;

    /**
     * 使用信号量
     *
     * @param args
     * @throws InterruptedException
     */
//    public static void main(String[] args) throws InterruptedException {
//        String[] strArr = {"a", "b", "c"};
//        int[] intArr = {1, 2, 3};
//        AtomicInteger i = new AtomicInteger(0);
//        AtomicInteger j = new AtomicInteger(0);
//        new Thread(() -> {
//            while (i.get() < 3) {
//                try {
//                    intSemaphore.acquire();
//                    System.out.println("当前线程名:" + Thread.currentThread().getName() + "   当前值:" + intArr[i.get()]);
//                    i.getAndIncrement();
//                    strSemaphore.release();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (j.get() < 3) {
//                try {
//                    strSemaphore.acquire();
//                    System.out.println("当前线程名:" + Thread.currentThread().getName() + "   当前值:" + strArr[j.get()]);
//                    j.getAndIncrement();
//                    intSemaphore.release();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
    public static void main(String[] args) {
        String[] strArr = {"a", "b", "c"};
        int[] intArr = {1, 2, 3};
        AtomicInteger i = new AtomicInteger(0);
        AtomicInteger j = new AtomicInteger(0);
        new Thread(() -> {
            while (i.get() < 3) {
                lock.lock();
                try {
                    if (!flag) {
                        condition.await();
                    }
                    flag = false;
                    System.out.println("当前线程名:" + Thread.currentThread().getName() + "   当前值:" + intArr[i.get()]);
                    i.incrementAndGet();
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (j.get() < 3) {
                lock.lock();
                try {
                    if (flag) {
                        condition.await();
                    }
                    flag = true;
                    System.out.println("当前线程名:" + Thread.currentThread().getName() + "   当前值:" + strArr[j.get()]);
                    j.incrementAndGet();
                    condition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
