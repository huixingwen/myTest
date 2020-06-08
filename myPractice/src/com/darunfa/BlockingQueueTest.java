package com.darunfa;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 15:34
 * @描述
 */
public class BlockingQueueTest {

    public static void main(String[] args) {

        BlockingQueue<String> b = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() +" put 1");
                b.put("1");
                System.out.println(Thread.currentThread().getName() +" put 2");
                b.put("2");
                System.out.println(Thread.currentThread().getName() +" put 3");
                b.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();


        new Thread(() -> {
            try {
                Thread.sleep(3000);
                String str1 = b.take();
                System.out.println(Thread.currentThread().getName() +" 消费 " + str1);

                Thread.sleep(3000);
                String str2 = b.take();
                System.out.println(Thread.currentThread().getName() +" 消费 " + str2);

                Thread.sleep(3000);
                String str3 = b.take();
                System.out.println(Thread.currentThread().getName() +" 消费 " + str3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
