package com.darunfa;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 8:51
 * @描述 读写锁
 */
public class ReadWriteLockTest {

    Map<String,String> map = new HashMap<>();
    ReentrantReadWriteLock r = new ReentrantReadWriteLock();

    public void put(String key, String value) {
        r.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "写操作开始" + key);
        map.put(key,value);
        try {
            //模拟执行任务的所消耗时间
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "写操作完成");
        r.writeLock().unlock();
    }

    public void get(String key) {
        r.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "读操作开始");
        String value = map.get(key);
        try {
            //模拟执行任务的所消耗时间
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "读操作完成" + value);
        r.readLock().unlock();
    }

    public static void main(String[] args) {

        ReadWriteLockTest r = new ReadWriteLockTest();

        //写操作,保证原子性和独占锁
        for (int i = 1; i < 6; i++) {
            final int a = i;
            new Thread(() -> {
                r.put(a+"", a+"");
            },i + "").start();
        }

        //数据可以共享,可以一起读,不保证独占
        for (int i = 1; i < 6; i++) {
            final int a = i;
            new Thread(() -> {
                r.get(a+"");
            },i + "").start();
        }

    }
}
