package com.kelly.imooc.stackANDqueue03.queue;

/**
 * Created by 贺望香 on 2019/2/16.
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
