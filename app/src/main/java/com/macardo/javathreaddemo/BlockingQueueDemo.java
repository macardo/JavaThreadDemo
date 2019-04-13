package com.macardo.javathreaddemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

public class BlockingQueueDemo {
    public static void main(String[] args){
        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);

        Executors.defaultThreadFactory().newThread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0;;i++){
                        Thread.sleep(100);
                        //抛出异常的添加元素方法
                        blockingQueue.add(i);
                        //无限期阻塞线程的添加元素方法
                        //blockingQueue.put(i);
                        System.out.println("Make value: " + i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Executors.defaultThreadFactory().newThread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (;;){
                        Thread.sleep(100);
                        //抛出异常的移除元素方法
                        int value = blockingQueue.remove();
                        //无限期阻塞线程的起初元素方法
                        //int value = blockingQueue.take();
                        System.out.println("Get value: " + value);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
