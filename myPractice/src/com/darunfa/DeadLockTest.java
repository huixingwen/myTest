package com.darunfa;

//资源类
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "自己持有" + lockA +"尝试获取"+ lockB);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println("执行任务....");
            }
        }
    }
}

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/25 15:58
 * @描述 死锁的代码
 */
public class DeadLockTest {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"AA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BB").start();
    }
}
