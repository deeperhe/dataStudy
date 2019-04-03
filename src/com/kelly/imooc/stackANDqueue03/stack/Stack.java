package com.kelly.imooc.stackANDqueue03.stack;

/**
 * Created by 贺望香 on 2019/2/16.
 */
public interface Stack<E> {
    void push(E e);  // 添加元素
    E pop();       // 拿出栈顶元素  出栈
    E peek();      // 查看栈顶元素
    int getSize();
    boolean isEmpty(); // 栈是否为空
}
