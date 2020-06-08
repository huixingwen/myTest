package com.darunfa;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/23 16:45
 * @描述  手写自旋锁
 */
public class AtomicIntegerTest {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"获取锁");
        
        //获取锁
        while (!atomicReference.compareAndSet(null,thread)) {

        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        //释放锁
        System.out.println(thread.getName()+"释放锁");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        new Thread(() -> {
            atomicIntegerTest.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicIntegerTest.myUnlock();
        },"aa").start();

        Thread.sleep(1000);

        new Thread(() -> {
            atomicIntegerTest.myLock();
            atomicIntegerTest.myUnlock();
        },"bb").start();

    }
}
