package com.darunfa;

import java.util.concurrent.CountDownLatch;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 9:44
 * @描述 倒计时,等待所有的线程执行完了执行代码
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch c = new CountDownLatch(5);

        for (int i = 1; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"同学上完了自习");
                c.countDown();
            },MyEnum.findMsgByCode(i)).start();
        }

        c.await();
        System.out.println("******88,班长锁门");
        System.out.println(MyEnum.ONE);
        System.out.println(MyEnum.ONE.getCode());
        System.out.println(MyEnum.ONE.getMsg());

    }
}
