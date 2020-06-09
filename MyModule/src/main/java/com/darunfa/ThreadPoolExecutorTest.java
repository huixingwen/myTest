package com.darunfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/25 11:35
 * @描述
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i < 11; i++) {
                executorService.execute(() -> {
                    //打印
                    System.out.println(Thread.currentThread().getName() + " 处理");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
