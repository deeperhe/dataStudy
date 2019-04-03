package com.kelly.imooc.stackANDqueue03.stack;

import com.kelly.imooc.stackANDqueue03.UpdateArray;

/**
 * Created by 贺望香 on 2019/2/16.
 * 说明：因为动态数组中 做了空异常和数组越界的判断，栈中只需调用即可，不用做相应的判断了
 * 本类中的方法的时间复杂度都是 O(1)的，说明这些方法的时间性能上是非常的好的
 * 这些方法是isEmpty()，getSize()，push()，pop()，peek()
 */
public class ArrayStack<E> implements Stack<E> {

    UpdateArray<E> array;

    public ArrayStack(int capacity) {
        array = new UpdateArray<>(capacity);
    }

    public ArrayStack() {
        array = new UpdateArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    // 是调用的UpdateArray里面的方法，满足条件会自动进行扩容操作，用户不用考虑空间不够的问题
    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack:");
        result.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1)
                result.append(',');
        }
        result.append("] top");
        return result.toString();
    }
}
