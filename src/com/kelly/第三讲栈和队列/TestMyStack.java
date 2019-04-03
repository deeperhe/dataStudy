package com.kelly.第三讲栈和队列;

/**
 * Created by 贺望香 on 2019/1/28.
 */
public class TestMyStack {
    public static void main(String[] args) {
        MyStack ms = new MyStack(4);
        ms.push(23);
        ms.push(12);
        ms.push(1);
        ms.push(90);
        System.out.println(ms.isEmpty());
        System.out.println(ms.isFull());

        while (!ms.isEmpty()) {
            System.out.print(ms.pop() + ",");
        }

        System.out.println(ms.isEmpty());
        System.out.println(ms.isFull());
    }
}
