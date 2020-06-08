package com.wenxinghui.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wenxinghui
 * @CreateTime 2020/5/18 9:57
 * @Describe
 */
public class MyListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
            if (list.size() == 3) {
                test(list);
            }
        }
        if (list.size() > 0) {
            test(list);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void test(List<Integer> list) {
        if (list.size() > 0) {
            list.clear();
        }
    }
}
