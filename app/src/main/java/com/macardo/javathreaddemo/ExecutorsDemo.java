package com.macardo.javathreaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 线程池实例
 */
public class ExecutorsDemo {
    public static void main(String[] args){

/*        //线程工厂的使用
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        Thread thread = threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });*/

/*        //使用线程池运行Runnable对象
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run on thread: " + Thread.currentThread().getName());
            }
        });*/

/*//使用线程池运行Callable对象并获取返回值和异常
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (true){
                    throw new RuntimeException("Hello Callable");
                }
                return Thread.currentThread().getName();
            }
        });
        try {
            System.out.println("Result:" + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

/*        //在指定的延时执行一个Runnable
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(new Runnable() {
            long startTime = System.currentTimeMillis();
            @Override
            public void run() {
                System.out.println("Run at: " + (System.currentTimeMillis() - startTime));
            }
        },1000,TimeUnit.MILLISECONDS);//TimeUnit:时间颗粒度

        //关闭线程池，等待任务完成后关闭
        scheduledExecutorService.shutdown();

        //关闭线程池，立即关闭
        //scheduledExecutorService.shutdownNow();*/

        //缓存线程池和固定线程数量线程池的区别
/*        //缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0;i < 10;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Run on thread: " + Thread.currentThread().getName());
                }
            });
        }*/
        //固定线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0;i < 10;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Run on thread: " + Thread.currentThread().getName());
                }
            });
        }
    }
}
