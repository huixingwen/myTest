package com.darunfa;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/24 10:39
 * @描述
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier c = new CyclicBarrier(7, () -> {
            System.out.println("***集齐7颗龙珠,召唤神龙");
        });

        for (int i = 1; i < 8; i++) {
            new Thread(() -> {
                System.out.println("集齐第" + Thread.currentThread().getName() +"颗龙珠");
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
