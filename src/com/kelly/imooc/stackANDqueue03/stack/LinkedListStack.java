package com.kelly.imooc.stackANDqueue03.stack;

/**
 * Created by 贺望香 on 2019/2/26.
 * 因为 链表中插入第一个元素和删除第一个元素，时间复杂度是大O(1)的
 * 符合栈的特点，特用此来改写下 栈的底层实现
 * 同时，之前我们用数组对栈也做了底层实现，现又用链表对栈做了底层实现
 * 所以，在ComparsionStackMain类中，比较2者的性能，发现，当数据量不是很大的时候，链表栈运行的时间低于数组栈
 * 但当数据量大的时候，数组栈运行的时间就低于链表栈了
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    // 查看链表的第一个元素是谁
    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack:top");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
