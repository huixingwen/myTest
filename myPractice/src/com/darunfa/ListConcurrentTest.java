package com.darunfa;

import java.util.*;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/20 10:23
 * @描述
 */
public class ListConcurrentTest {

    public static void main(String[] args) {

        Map map = new HashMap();

        Set set = new HashSet();

        //并发修改异常 --> java.util.concurrentModificationException
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add("aaaa");
                System.out.println(list);
            },"T"+i).start();
        }
    }
}
