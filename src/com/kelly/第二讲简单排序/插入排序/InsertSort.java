package com.kelly.第二讲简单排序.插入排序;

/**
 * Created by 贺望香 on 2019/1/27.
 */
public class InsertSort {
    public static void sort(long[] arr){
        long temp = 0;
        // 从什么位置开始插入 前面保持有数据  找插入点
        for(int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int j = i;
            while (j > 0 && arr[j] >= temp) {
                // 满足循环条件，进行右移
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    // 测试
    public static void main(String[] args) {
        long[] arr1 = new long[]{34,23,2,1,-4};
        // 打印前
        System.out.print("[");
        for (long num : arr1){
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();

        sort(arr1);
        // 打印后
        System.out.print("[");
        for (long num : arr1){
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }





}
