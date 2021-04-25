package com.haobai.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author haobai
 * @description:
 * @date 2021/3/21 14:30
 */
public class 奇偶数打印 {

    private static Semaphore odd = new Semaphore(1);

    private static Semaphore even = new Semaphore(0);

    private static CountDownLatch latch = new CountDownLatch(2);

    private static volatile int target = 1;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (target < 100) {
                try {
                    odd.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("奇数线程打印 target：" + target++);
                even.release();
            }
            latch.countDown();
        }).start();

        new Thread(() -> {
            while (target < 100) {
                try {
                    even.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("偶数线程打印 target：" + target++);
                odd.release();
            }
            latch.countDown();
        }).start();

        latch.await();
        System.out.println("1111");
    }


//    static class Resource {
//        private Integer count;
//
//        private Boolean flag = true;
//
//        public Resource(Integer count, Boolean flag) {
//            this.count = count;
//            this.flag = flag;
//        }
//
//        public Integer getCount() {
//            return count;
//        }
//
//        public void setCount(Integer count) {
//            this.count = count;
//        }
//
//        public Boolean getFlag() {
//            return flag;
//        }
//
//        public void setFlag(Boolean flag) {
//            this.flag = flag;
//        }
//    }
//
//    static class OddTask implements Runnable {
//        private Resource resource;
//
//        public OddTask(Resource resource) {
//            this.resource = resource;
//        }
//
//        @SneakyThrows
//        @Override
//        public void run() {
//            while (resource.count <100) {
//                synchronized (resource) {
//                    if (resource.flag) {
//                        System.out.println("奇数线程打印 target：" + resource.count);
//                        resource.setCount(++resource.count);
//                        resource.setFlag(false);
//                        resource.notify();
//                    } else {
//                        resource.wait();
//                    }
//                }
//            }
//        }
//    }
//
//    static class EvenTask implements Runnable {
//        private Resource resource;
//
//        public EvenTask(Resource resource) {
//            this.resource = resource;
//        }
//
//        @SneakyThrows
//        @Override
//        public void run() {
//            while (resource.count <100) {
//                synchronized (resource) {
//                    if (!resource.flag) {
//                        System.out.println("偶数线程打印 target：" + resource.count);
//                        resource.setFlag(true);
//                        resource.setCount(++resource.count);
//                        resource.notify();
//                    } else {
//                        resource.wait();
//                    }
//                }
//
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Resource resource = new Resource(1, true);
//        new Thread(new OddTask(resource)).start();
//        new Thread(new EvenTask(resource)).start();
//    }
}
