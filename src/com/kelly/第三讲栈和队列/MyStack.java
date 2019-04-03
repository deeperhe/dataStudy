package com.kelly.第三讲栈和队列;

/**
 * Created by 贺望香 on 2019/1/28.
 * 先进后出 或 后进先出
 */
public class MyStack {
    // 底层实现是一个数组
    private long[] arr;
    // 栈顶
    private int top;

    public MyStack(){
        arr = new long[10];
        top = -1;
    }

    // 带参的构造方法
    public  MyStack(int maxsize){
        arr = new long[maxsize];
        top = -1;
    }

    /*
    * 添加数据
    */
    public void push(int value){
        // top 为0了
        arr[++top] = value;
    }
    /*
    * 移除数据
    */
    public long pop(){
        return arr[top--];
    }

    /*
    * 查看数据  和pop类似  但不会弹出来
    */
    public long peek(){
        return arr[top];
    }

    /*
    * 判断是否为空
    */
    public boolean isEmpty(){
        return top == -1;
    }

    /*
    * 判断是否满了
    */
    public boolean isFull(){
        return top == arr.length - 1; // 已经满了 已经指向最后一个数
    }




}

