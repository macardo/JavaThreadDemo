package com.macardo.javathreaddemo;

/**
 * 线程局部变量
 */
public class ThreadLocalDemo {

    public static void main(String[] args){
        final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return -1;
            }
        };

        //获取值
        System.out.println(Thread.currentThread().getName() + "-value:" + threadLocal.get());
        //设置值
        threadLocal.set(5);
        System.out.println(Thread.currentThread().getName() + "-new value:" + threadLocal.get());
        //移除值
        threadLocal.remove();
        System.out.println(Thread.currentThread().getName() + "-remove and value:" + threadLocal.get());

        //重新设置值
        threadLocal.set(5);

        //创建新线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //获取值
                System.out.println(Thread.currentThread().getName() + "-value:" + threadLocal.get());
                //设置值
                threadLocal.set(5);
                System.out.println(Thread.currentThread().getName() + "-new value:" + threadLocal.get());
                //移除值
                threadLocal.remove();
                System.out.println(Thread.currentThread().getName() + "-remove and value:" + threadLocal.get());
            }
        });
        thread.start();
    }
}
