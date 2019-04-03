package com.kelly.第一讲数组;

/**
 * Created by 贺望香 on 2019/1/26.
 */
public class OOArray {
    private long[] arr;
    private int elements; //有效数据长度
    public  OOArray(){
        arr = new long[50];
    }
    public OOArray(int maxsize) {
       arr = new long[maxsize];
    }
    /*
    * 添加数据
    */
    public void insert(long value) {
         // elements初始值为0
         arr[elements] = value;
         elements++;
    }
    /*
    * 显示数组数据
    */
    public void display(){
        System.out.print("[");
        for(int i = 0;i < elements;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    /*
    *  查找数据，根据传入的值查找
    */
    public int search(long value){
        int i; // i表示下标
        for(i = 0;i < elements;i++){
            if (value == arr[i]) {
                break;
            }
        }
        // 如果下标查找到最后一个，还没找到，返回为-1
        if(i == elements){
            return -1;
        } else {
            return i;
        }
    }

    /*
    *  查找数据，根据索引来查找
    */
    public long get(int index){
        if (index >= elements || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }
    /*
    * 删除数据--有效长度减一
    */
    public void delete(int index){
        if (index >= elements || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            for(int i = index;i < elements;i++){
                // 前面的值等于后面的这一个
                arr[index] = arr[index+1];
            }
            // 对有效长度进行更新
            elements--;
        }
    }
    /*
    * 更新数据
    */
    public void change(int index,int newvalue){
        if (index >= elements || index < 0){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = newvalue;
        }
    }



}
