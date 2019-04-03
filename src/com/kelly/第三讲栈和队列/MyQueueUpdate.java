package com.kelly.第三讲栈和队列;

/**
 * Created by 贺望香 on 2019/1/28.
 * 循环列队
 * 使用 insert 的改良版 因为原来的insert有个 ++ 操作，当全部删除（删4个，容量也为4），在加入的时候，会出现数组越界问题
 */
public class MyQueueUpdate {
    // 底层使用数组
    private long[] arr;
    // 有效数据的大小
    private int elements;
    // 队头
    private int front;
    // 队尾
    private int end;

    // 默认构造方法
    public MyQueueUpdate(){
        arr = new long[10];
        elements = 0;
        front = 0;
        end = -1;
    }
    // 带参的构造方法，参数为数组的大小
    public MyQueueUpdate(int maxsize){
        arr = new long[maxsize];
        elements = 0;
        front = 0;
        end = -1;
    }

    /*
    * 添加数据  从队尾插入
    */
    public void insert(long value){
        // 很重要  循环队列
        if (end == arr.length - 1) {
            end = -1;
        }
        arr[++end] = value;
        elements ++; // 有效数据递增
    }

    /*
   * 删除数据  从队头删除
   */
    public long remove(){
        // 取得要删除的数
        long value = arr[front++];
        // 很重要  循环队列
        if (front == arr.length) {
            front = 0;
        }
        elements--;
        return value;  // 往后移一个
    }

    /*
    * 查看数据  从队头查看
    */
    public long peek(){
        return arr[front];
    }

    /*
    * 判断是否为空
    */
    public boolean isEmpty(){
        return elements == 0;
    }

    /*
    * 判断是否满了
    */
    public boolean isFull() {
        return elements == arr.length;
    }


}

