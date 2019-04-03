package com.kelly.第一讲数组;

/**
 * Created by 贺望香 on 2019/1/26.
 */
public class TestOOArray {
    public static void main(String[] args) {
        OOArray array = new OOArray();
        array.insert(10);
        array.insert(34);
        array.insert(89);
        array.display();
//        System.out.println(array.search(89));
//        System.out.println(array.get(2));
//        array.delete(2);
//        array.display();

        array.change(0,15);
        array.display();
    }
}
