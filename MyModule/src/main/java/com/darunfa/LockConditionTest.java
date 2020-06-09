package com.darunfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Sour{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while (num != 1) {
                c1.await();
            }
            //干活
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
            //改变标记
            num = 2;
            //唤醒c2
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while (num != 2) {
                c2.await();
            }
            //干活
            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
            //改变标记
            num = 3;
            //唤醒c3
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while (num != 3) {
                c3.await();
            }
            //干活
            for (int i = 1; i < 16; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
            }
            //改变标记
            num = 1;
            //唤醒c1
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 17:00
 * @描述  AA线程打印5次,BB线程打印10次,CC线程打印15次,总共循环10次
 */
public class LockConditionTest {

    public static void main(String[] args) {
        Sour s = new Sour();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.print5();
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.print10();
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                s.print15();
            }
        },"CC").start();
    }
}
