package com.haobai.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author haobai
 * @description:
 * @date 2021/3/1 20:13
 */
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();

        }
    }
}
