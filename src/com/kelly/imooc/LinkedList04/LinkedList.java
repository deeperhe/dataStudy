package com.kelly.imooc.LinkedList04;

/**
 * Created by 贺望香 on 2019/2/26.
 */
public class LinkedList<E> {
    // 外部不能访问  对于用户来说  不需要了解链表底层结构是怎样的  “屏蔽底层的实现细节”
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

    // private Node head; // 为了访问链表中的节点，相应的，我们要把链表的头给储存起来，链表的头叫head，为Node类型
    private Node dummyHead; // 虚拟头结点  解决第一个节点没有头节点的问题，不存储任何元素
    private int size;  // 记录链表中的元素

    public LinkedList() {
        // head = null;
        // so，对于一个空的链表来说，他是存在一个节点的，这个节点就是那个唯一的“虚拟头节点”
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    // 在链表中间添加新的元素e  【找到要添加节点的前一个节点】
    // 链表顺序很重要
    // 在链表的index(0 - based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index");

        Node prev = dummyHead;
        // 要找到待插入节点的前面那个节点  找0之前的节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//                Node node = new Node(e);
//                node.next = prev.next;
//                prev.next = node;
        // ======下面这句话代替上面的3句话
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        // 首先创建一个新的节点
//            Node node = new Node(e);
//            node.next = head;
//            node = node;

        // ===== 下面这句话是对上面3句话的翻译
//            head = new Node(e,head);
//            size ++;
        //---有了dummyHead，虚拟头节点后，就可以直接复用add这个方法了
        add(0, e);

    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0 - based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed.Illegal index");
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改链表的第index(0 - based)个位置的元素e
    // 在链表中不是一个常用的操作，练习用：
    public void set(int index,E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Set failed.Illegal index");

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        current.e = e;
        }
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        // 从头开始遍历
        Node current = dummyHead.next;
        while (current != null){
            if (current.e.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    // 从链表中删除index(0 - based)位置的元素，返回删除的元素
    // 在链表中不是一个常用的操作，练习用：
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed.Illegal index");
        // 和for循环一起，找到待删除元素的前面的那个节点
        Node prev = dummyHead;
        for (int i = 0; i < index ; i++)
            prev = prev.next;

        Node returnNode = prev.next; // 待删除的节点returnNode
        prev.next = returnNode.next;
        returnNode.next = null;
        size -- ;
        return returnNode.e;

    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node current = dummyHead.next;
//        while (current != null){
//            res.append(current + "->");
//            current = current.next;
//        }
        // ======下面的实现是和上面的4 句代码相同的for循环
        for(Node cur = dummyHead.next;cur != null;cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }
}
