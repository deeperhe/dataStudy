package com.kelly.imooc.stackANDqueue03;

import com.kelly.imooc.stackANDqueue03.stack.ArrayStack;
import com.kelly.imooc.stackANDqueue03.stack.LinkedListStack;
import com.kelly.imooc.stackANDqueue03.stack.Stack;

import java.util.Random;

/**
 * Created by 贺望香 on 2019/2/26.
 */
public class ComparsionStackMain {
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
           stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 1000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack, time: " + time2 + " s");
    }
}
