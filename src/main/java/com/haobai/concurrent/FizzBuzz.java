package com.haobai.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author haobai
 * @description: 使用信号量进行通信
 * @date 2021/3/1 20:34
 */
public class FizzBuzz {

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private Semaphore num = new Semaphore(1);

    private Semaphore fizz = new Semaphore(0);

    private Semaphore buzz = new Semaphore(0);

    private Semaphore fizzbuzz = new Semaphore(0);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                num.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzz.acquire();
                printBuzz.run();
                num.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzz.acquire();
            printFizzBuzz.run();
            num.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            num.acquire();
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzz.release();
            } else if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.release();
            } else {
                printNumber.accept(i);
                num.release();
            }
        }
    }
}
