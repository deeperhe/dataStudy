package com.kelly.imooc.stackANDqueue03.queue;

import com.kelly.imooc.stackANDqueue03.UpdateArray;

/**
 * Created by 贺望香 on 2019/2/16.
 * 出队 dequeue是O(n)：当索引为0的数据出队后，后面的数据都要向前移一个位置。  其余方法是【接口中】是O(1)
 */
public class ArrayQueue<E> implements Queue<E> {
    private UpdateArray<E> array;

    public ArrayQueue(int capacity) {
        array = new UpdateArray<>(capacity);
    }
    public ArrayQueue(){
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

    // 添加元素  依然的  当动态数组中容量不够的时候  可以进行扩容操作
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // 取出元素 达到一定的条件后 会进行缩容操作
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue:");
        result.append("front[");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1)
                result.append(',');
        }
        result.append("] tail");
        return result.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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
