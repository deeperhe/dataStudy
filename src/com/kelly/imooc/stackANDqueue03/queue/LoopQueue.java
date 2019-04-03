package com.kelly.imooc.stackANDqueue03.queue;

/**
 * Created by 贺望香 on 2019/2/16.
 * 循环队列，不在复用动态数组UpdateArray，自己写底层
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        // 循环队列中要浪费一个元素，所以要将用户传进来的容积进行 + 1 操作
         data = (E[])new Object[capacity + 1];
         front = 0;
         tail = 0;
         size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        // 用一个空间被我们浪费掉了
        return data.length -1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        // 1、判断队列是否是满  条件是：(tail + 1) % 队列长度 == front
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    // 我理解还有点问题
    @Override
    public E dequeue() {
       /* // 看队列是否为空
        if (isEmpty())
           throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        // 因为要出队，所以定位到索引为0
        E result = data[front];
        // 为了防止出现闲逛的对象  手动设为空  让jvm回收
         data[front] = null;
         front = ((front + 1)) % data.length;
         size--;
         if (size == getCapacity() /4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
         return result;*/
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity) {
        /*// 要浪费一个空间
        E[] newData =(E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // newData[i] 不对应 data[i] 有个front的偏移的【？我理解有点问题】
            newData[i] = data[(i + front) % data.length];
            data = newData;
            front = 0;
            tail = size;
        }*/
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[(i + front) % data.length];

        data = newData;
        front = 0;
        tail = size;
    }

    // 我有点不太理解这里
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
