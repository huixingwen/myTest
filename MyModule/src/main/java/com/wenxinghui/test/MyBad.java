package com.wenxinghui.test;

/**
 * @创建人 wenxinghui
 * @创建时间 2020/4/26 10:38
 * @描述
 */
public class MyBad {
    public static MyStack s = new MyStack();

    static {
        s.push(new Object());
        s.pop();
        s.push(new Object());
    }

}
