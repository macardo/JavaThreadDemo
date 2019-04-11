package com.macardo.javathreaddemo;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args){
        final Timer timer = new Timer();


/*        //在指定的延迟执行任务
        timer.schedule(new TimerTask() {
            long startTime = System.currentTimeMillis();
            @Override
            public void run() {
                //预计执行时间
                System.out.println("Schedule time:"+(scheduledExecutionTime()-startTime));
                //实际执行时间
                System.out.println("Run at:"+ (System.currentTimeMillis() - startTime));
            }
        },1000);*/

/*        //重复执行任务
        timer.schedule(new TimerTask() {
            long startTime = System.currentTimeMillis();
            @Override
            public void run() {
                //预计执行时间
                System.out.println("Schedule time:"+(scheduledExecutionTime()-startTime));
                //实际执行时间
                System.out.println("Run at:"+ (System.currentTimeMillis() - startTime));
            }
        },0,1000);*/

       /* timer.scheduleAtFixedRate(new TimerTask() {
            long startTime = System.currentTimeMillis();
            @Override
            public void run() {
                //预计执行时间
                System.out.println("Schedule time:"+(scheduledExecutionTime()-startTime));
                //实际执行时间
                System.out.println("Run at:"+ (System.currentTimeMillis() - startTime));
            }
        },0,1000);*/

/*        //起干扰作用的线程
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },900);*/

/*        //取消任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                cancel();//此处不能取消，因为正在执行的任务不会被终止
                System.out.println("Run");
            }
        };
        timer.schedule(timerTask,1000);
        timer.cancel();//此处可以取消*/

        //取消循环任务
        TimerTask timerTask = new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                //任务开始执行后不可取消，重复执行的后续任务可以取消
                if (count ==2) cancel();//问题：取消任务后程序没有退出*//*

                //正在执行的任务不受影响，未执行的任务将被丢弃
                if (count ==2) timer.cancel();
                System.out.println("Run:" + ++count);
            }
        };
        timer.schedule(timerTask,0,1000);
        //*timer.cancel();//不可以，问题：导致计时器在任务执行之前被关闭
    }
}
