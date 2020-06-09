package com.darunfa;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {

    //定义控制消费和生产的标记,保证变量的可见性
    private volatile boolean flag = true;
    //定义线程操作的变量,多线程下的变量用原子变量,默认值为0
    private AtomicInteger atomicInteger = new AtomicInteger();
    //定义阻塞队列,用接口定义,构造函数传参
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    //定义生产的方法,口诀判断干活通知
    public void MyProd() throws InterruptedException {
        int result = 0;
        Boolean offerFlag;
        //判断
        while (flag) {
            //生产
            result = atomicInteger.incrementAndGet();
            //
            offerFlag = blockingQueue.offer(atomicInteger + "",2L,TimeUnit.SECONDS);
            if (offerFlag) {
                System.out.println(Thread.currentThread().getName() + "生产成功 " + atomicInteger);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产失败");
            }
            //睡一秒
            Thread.sleep(1000);
        }
        System.out.println("接到通知,生产停止.......");
    }

    //定义消费的方法,口诀判断干活通知
    public void MyCons() throws InterruptedException {
        String pollFlag;
        //判断
        while (flag) {
            //消费
            pollFlag = blockingQueue.poll(2L,TimeUnit.SECONDS);
//            Thread.sleep(300);
            //消费
            if (pollFlag == null || "".equalsIgnoreCase(pollFlag)) {
                //消费不到消息,消费者要退出,此时需要通知生产者退出
                flag = false;
                //没有消费到
                System.out.println("消费失败,消费停止.......");
                //退出
                return;
            }else {
                System.out.println(Thread.currentThread().getName() + "消费成功 " + pollFlag);
            }
        }
    }

    //停止生产消费
    public void stop(){
        this.flag = false;
    }
}

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/25 8:42
 * @描述  用阻塞队列做经典生产者消费者模式,用到的技术  volatile/AtomicInteger/cas/BlockingQueue
 */
public class BlockingQueueProdCons {

    public static void main(String[] args) throws InterruptedException {

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(3));

        new Thread(() -> {
            try {
                myResource.MyProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(() -> {
            try {
                myResource.MyCons();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();

        //允许5秒
        Thread.sleep(5000);
        myResource.stop();
        System.out.println("大老板通知停止生产消费.......");
    }
}
