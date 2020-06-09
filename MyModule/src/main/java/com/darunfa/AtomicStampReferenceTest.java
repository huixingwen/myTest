package com.darunfa;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/20 9:59
 * @描述 时间戳的原子引用
 */
public class AtomicStampReferenceTest {

    static AtomicStampedReference<Integer> a = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {

        //开启新此线程
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改值
            a.compareAndSet(100, 101, 1, a.getStamp() + 1);
            a.compareAndSet(101, 100, a.getStamp(), a.getStamp() + 1);

        },"T1").start();

        new Thread(() -> {
            int stamp = a.getStamp();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改值
            boolean b = a.compareAndSet(100, 2019, stamp, a.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"==="+b);
            System.out.println(a.getStamp()+"==="+a.getReference());

        },"T2").start();
    }
}
