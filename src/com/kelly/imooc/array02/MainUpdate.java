package com.kelly.imooc.array02;

/**
 * Created by 贺望香 on 2019/2/14.
 */
public class MainUpdate {
    public static void main(String[] args) {

//        int[] arr = new int[10];
//        for(int i = 0;i < arr.length; i++){
//            arr[i] = i;
//        }
//        int[] scores = new int[]{100,99,66};
//        for (int score : scores) {
//            System.out.println(score);
//
//   【注意此处传入的是Integer 包装类型】
    UpdateArray<Integer> array = new UpdateArray();
    for(int i = 0; i < 10; i++){
        array.addLast(i);
    }
//        System.out.println(array);
        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        System.out.println("------------------------------");
        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
    }


}
