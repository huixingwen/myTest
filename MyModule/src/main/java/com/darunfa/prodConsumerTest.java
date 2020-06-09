package com.darunfa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Source{

     private int num = 0;
     private Lock lock = new ReentrantLock();
     private Condition con = lock.newCondition();

     //加1操作
    public void add() throws InterruptedException {
        //加锁
        lock.lock();
        try {
            //判断
            while (num != 0) {
                //等待
                con.await();
            }
            //干活
            num++;
            System.out.println(Thread.currentThread().getName() + "线程 num = " + num);
            //通知
            con.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //减1操作
    public void cut() throws InterruptedException {
        //加锁
        lock.lock();
        try {
            //判断
            while (num == 0) {
                //等待
                con.await();
            }
            //干活
            num--;
            System.out.println(Thread.currentThread().getName() + "线程 num = " + num);
            //通知
            con.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 16:04
 * @描述  多线程模拟生产消费者模式,进行加1减1的循环操作
 *          线程操作资源类
 *          判断干活通知
 *          注意虚假唤醒
 */
public class prodConsumerTest {

    public static void main(String[] args) {
        Source source = new Source();

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    source.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    source.cut();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    source.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    source.cut();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
