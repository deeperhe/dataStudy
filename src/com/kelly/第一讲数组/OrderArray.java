package com.kelly.第一讲数组;

/**
 * Created by hwx on 2019/1/26.
 */
public class OrderArray {
    private long[] arr;
    private int elements; //有效数据长度
    public  OrderArray(){
        arr = new long[50];
    }
    public OrderArray(int maxsize) {
        arr = new long[maxsize];
    }
    /*
    *  添加数据，整体往后移
    */
    public void insert(long value) {
        int i;
        // 确保加进来的数据是有序的
        for( i = 0; i < elements;i++){
            if(arr[i] > value){
                break;
            }
        }
        for (int j = elements;j > i;j--){
            // 把前面的数赋值给后面的
            arr[j] = arr[j-1];
        }
        // 经过上面的操作，i就空出来了，留来装value
        arr[i] = value;
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

    /*
    * 二分查找 -- 有序
    */
    public int binarySearch(long value) {
        int middle = 0;
        int low = 0; // 最左边
        int pow = elements; // 最右边
        while (true){
            middle = (pow + low) / 2;
            if (arr[middle] == value) {
                return middle;
            } else if(low > pow){
                return -1;
            } else {
                // 判断往左还是往右走 中间的数大于要查找的数  应该往左走 因为是有序排的
                if (arr[middle] > value) {
                    pow = middle -1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }

}

