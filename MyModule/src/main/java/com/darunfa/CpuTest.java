package com.darunfa;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/25 10:34
 * @描述
 */
public class CpuTest {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println((double) Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println((double) Runtime.getRuntime().maxMemory()  / 1024 / 1024);
    }
}
