package com.kelly.第一讲数组;

/**
 * Created by 贺望香 on 2019/1/26.
 */
public class TestArray {
    public static void main(String[] args) {
//        // 创建数组
//        long [] arr = new long[]{2,3,4};
//        // 访问数据项
//        arr[0] =1;
//        System.out.println(arr[2]);
        OrderArray arr = new OrderArray();
        arr.insert(10);
        arr.insert(34);
        arr.insert(3);
        arr.insert(15);
        arr.display();

    }
}
