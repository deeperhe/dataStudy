package com.kelly.imooc.stackANDqueue03.queue;


/**
 * Created by 贺望香 on 2019/2/26.
 */
public class LinkedListQueue<E> implements Queue<E> {
    //使用链表实现  需要一个链表的头节点
    private class Node {
        public E e; // 存放元素
        public Node next; // 存放next指针

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 入队操作，是从链表的尾部进行  考虑时间复杂度O(1)
    @Override
    public void enqueue(E e) {
       if (tail == null){
           tail = new Node(e);
           head = tail;
       } else {
           tail.next = new Node(e);
           tail = tail.next;
       }
       size ++;
    }

    // 出队操作，是从链表的头部进行  考虑时间复杂度O(1)
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        Node retNode = head;  // 出队元素的节点
        head = head.next;
        retNode.next = null;
        if(head == null)
            tail = null;
        size --;
        return retNode.e;
    }

    // 队首元素是谁
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        // 队首负责出队
        res.append("Queue:front");
        Node cur = head;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        // 队尾负责入队
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}

