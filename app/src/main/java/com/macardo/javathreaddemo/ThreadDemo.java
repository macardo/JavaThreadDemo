package com.macardo.javathreaddemo;

public class ThreadDemo {

    public static void main(String[] args){
        // 新建Thread类对象并重写run()方法
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                //do something
            }
        };

        //定义一个类实现一个Runnable接口，并使用一个Thread对象运行它
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });
    }
}
