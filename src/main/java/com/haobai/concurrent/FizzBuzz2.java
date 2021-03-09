package com.haobai.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 23:32
 */
public class FizzBuzz2 {
    private int n;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    private Lock lock = new ReentrantLock();

    private Condition fizz = lock.newCondition();

    private Condition buzz = lock.newCondition();

    private Condition fizzBuzz = lock.newCondition();

    private Condition number = lock.newCondition();

    private volatile boolean state = false;

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                lock.lock();
                try {
                    while (!state) {
                        fizz.await();
                    }
                    printFizz.run();
                    state = false;
                    number.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                lock.lock();
                try {
                    while (!state) {
                        buzz.await();
                    }
                    printBuzz.run();
                    state = false;
                    number.signal();
                } finally {
                    lock.unlock();
                }
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            lock.lock();
            try {
                while (!state) {
                    fizzBuzz.await();
                }
                printFizzBuzz.run();
                state = false;
                number.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (state) {
                    number.await();
                }
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzBuzz.signal();
                    state = true;
                } else if (i % 3 == 0) {
                    fizz.signal();
                    state = true;
                } else if (i % 5 == 0) {
                    buzz.signal();
                    state = true;
                } else {
                    printNumber.accept(i);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
