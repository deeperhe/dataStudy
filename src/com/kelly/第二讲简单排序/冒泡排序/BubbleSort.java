package com.kelly.第二讲简单排序.冒泡排序;

/**
 * Created by hwx on 2019/1/27.
 */
public class BubbleSort {
    /*
    * 1、进行 2 趟循环。第一层决定要循环的轮数；第二层从后往前一一进行比较
    * 2、关键：注意第二层循环中的循环条件
    */
    public static void sort(long[] arr){
        // [此处没有初始化值为0]
        long temp = 0;
        // [此处的arr.length没有减1]
        for(int i = 0;i < arr.length - 1;i++) {
            // 因为数组的下标是从 0 开始的  先从最后的数依次向前进行比较
            for(int j = arr.length - 1;j > i;j--){
                // [此处没有拿最后一个与前一个进行比较]
                if (arr[j] < arr[j - 1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
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

        BubbleSort.sort(arr1);
        // 打印后
        System.out.print("[");
        for (long num : arr1){
            System.out.print(num + " ");
        }
        System.out.print("]");
    }


}
