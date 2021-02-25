package com.haobai.scene.ticket;

/**
 * @author haobai
 * @description:
 * @date 2021/2/25 11:41
 */
public class Ticket {

    private volatile int ticket = 100;

    private Object objectMonitor = new Object();


    // 可以使用悲观锁 Synchronized 也可以使用Unsafe.compareAndSwapInt() 乐观锁 自旋进行相减，避免加解锁的开销
    public void sell() {
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (ticket > 0) {
                    System.out.println("卖出了一张票");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }
                } else {
                    System.out.println("票卖完了");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (objectMonitor) {
                    if (ticket > 0) {
                        System.out.println("卖出了一张票");
                        ticket--;
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {

                        }
                    } else {
                        System.out.println("票卖完了");
                    }
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                synchronized (objectMonitor) {
                    if (ticket > 0) {
                        System.out.println("卖出了一张票");
                        ticket--;
                        try {
                            Thread.sleep(7000);
                        } catch (InterruptedException e) {

                        }
                    } else {
                        System.out.println("票卖完了");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
