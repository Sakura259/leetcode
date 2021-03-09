package com.haobai.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 16:38
 */
public class 按序打印 {

    private AtomicInteger atomicIntegerB = new AtomicInteger(0);

    private AtomicInteger atomicIntegerC = new AtomicInteger(0);

//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        atomicIntegerB.incrementAndGet();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//    while (atomicIntegerB.get() != 1) {
//
//    }
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        atomicIntegerC.incrementAndGet();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        while (atomicIntegerC.get() != 1) {
//
//        }
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }

    private boolean secondFlag = false;
    private boolean threeFlag = false;

    private Object lock = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            secondFlag = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!secondFlag) {
                lock.wait();
            }
            printSecond.run();
            threeFlag = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!threeFlag) {
                lock.wait();
            }
            printThird.run();
        }
    }
}
