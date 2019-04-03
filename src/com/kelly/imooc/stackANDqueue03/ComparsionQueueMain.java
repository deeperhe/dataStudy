package com.kelly.imooc.stackANDqueue03;

import com.kelly.imooc.stackANDqueue03.queue.ArrayQueue;
import com.kelly.imooc.stackANDqueue03.queue.LinkedListQueue;
import com.kelly.imooc.stackANDqueue03.queue.LoopQueue;
import com.kelly.imooc.stackANDqueue03.queue.Queue;

import java.util.Random;

/**
 * Created by 贺望香 on 2019/2/16.
 */
public class ComparsionQueueMain {
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("linkedListQueue, time: " + time2 + " s");
    }
}

