package com.wenxinghui.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wenxinghui
 * @CreateTime 2020/5/18 10:50
 * @Describe
 */
public class MyMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
