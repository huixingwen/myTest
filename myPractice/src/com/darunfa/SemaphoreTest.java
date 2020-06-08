package com.darunfa;

import java.util.concurrent.Semaphore;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 10:37
 * @描述  抢车位,6辆车抢3个车位,多个线程抢多个资源
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        Semaphore s = new Semaphore(3);

        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"车抢到车位");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() +"车走了>>>>>>");
                    s.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
