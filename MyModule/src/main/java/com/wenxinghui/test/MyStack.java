package com.wenxinghui.test;

import java.util.EmptyStackException;

/**
 * @创建人 wenxinghui
 * @创建时间 2020/4/26 10:25
 * @描述
 */
public class MyStack {

    private Object[] elements = new Object[10];
    private int size = 0;

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[size--];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[2 * elements.length + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }
}
