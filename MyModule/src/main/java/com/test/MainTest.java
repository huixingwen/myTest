package com.test;

/**
 * @Author wenxinghui
 * @CreateTime 2020/5/9 10:19
 * @Describe
 */
public class MainTest {

    public static void main(String[] args) {
        int threadCount = 100;
        if (args != null && args.length > 0) {
            threadCount = Integer.parseInt(args[0]);
        }
        System.out.println("輸出的线程数：" + threadCount);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
