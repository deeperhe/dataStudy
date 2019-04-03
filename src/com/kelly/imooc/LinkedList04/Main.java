package com.kelly.imooc.LinkedList04;

/**
 * Created by 贺望香 on 2019/2/26.
 */
public class Main {
    public static void main(String[] args) {

        // 测插入元素
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i); // 大O(1)级别的，数组的addLast是大O(1)级别的
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        // ===测试删除===
        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
