package com.darunfa;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/19 10:12
 * @描述 volatile可见性的测试
 */

class SellPick{

    volatile int num = 0;

    public void addNumTo20(){
        this.num = 20;
    }

}

public class MyTest {

    public static void main(String[] args) {
        SellPick sellPick = new SellPick();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sellPick.addNumTo20();
            System.out.println(Thread.currentThread().getName() + " ->" + sellPick.num);
        },"线程A").start();


        //主线程
        while (sellPick.num == 0) {

        }

        System.out.println("主线程执行完毕");
    }
}
