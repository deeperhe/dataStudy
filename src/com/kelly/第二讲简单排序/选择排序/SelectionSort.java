package com.kelly.第二讲简单排序.选择排序;

/**
 * Created by hwx on 2019/1/27.
 */
public class SelectionSort {
    public static void sort(long[] arr) {
        int k = 0;
        long temp = 0;
        // 多少趟
        for(int i = 0;i < arr.length-1; i++){
            k = i; // k指向循环最开始的位置
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[k]){
                    k = j;  // k始终指向的是最小的数据
                }
            }
            // 与k指向的最小数据交换
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    // 测试
    public static void main(String[] args) {
        long[] arr1 = new long[]{2,34,5,12};
        // 打印前
        System.out.print("[");
        for (long num : arr1){
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();

        SelectionSort.sort(arr1);
        // 打印后
        System.out.print("[");
        for (long num : arr1){
            System.out.print(num + " ");
        }
        System.out.print("]");
    }

}
