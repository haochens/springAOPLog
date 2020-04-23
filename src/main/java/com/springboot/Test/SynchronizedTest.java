package com.springboot.Test;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.apache.tomcat.jni.Time;
import org.springframework.util.StopWatch;

import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 修饰实例方法，对当前实例对象加锁
 * 修饰静态方法，多当前类的Class对象加锁
 * 修饰代码块，对synchronized括号内的对象加锁
 */
public class SynchronizedTest implements Runnable {
    SynchronizedTest d1 =   new SynchronizedTest() ;

    public SynchronizedTest(){};
        //普通方法
        public  void accessResources(){
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+" is runing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //修饰静态方法    .class
        public synchronized static void accessResources0(){
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" is runing accessResources");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //修饰非静态方法

        //代码块1（对象）this指的是当前对象
        public  void accessResources1(){
            synchronized(this){
                try {
                    synchronized (this){
                        TimeUnit.SECONDS.sleep(5);
                    }
                    System.out.println(Thread.currentThread().getName()+" is runing  accessResources1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        //代码块1（CLASS类）
        public  void accessResources4(){
            synchronized(SynchronizedTest.class){//ClassLoader  class  ——-》堆   Class   所有的对象
                //有Class对象的所有的对象都共同使用这一个锁
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+" is runing");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    public static void main(String[] args) {
         //调用类锁
     /*   SynchronizedTest deno01=new SynchronizedTest();
        SynchronizedTest deno02=new SynchronizedTest();
        deno01.accessResources0();
        System.out.println(deno01.hashCode());
        deno02.accessResources0();
        System.out.println(deno02.hashCode());*/
        /**
         * 调用方法锁，加锁的方法上锁，没有synochronized 不同步
         */
        StopWatch watch = new StopWatch();
        StopWatch watch2 = new StopWatch();
        watch.start();
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        t1.start();
        watch.stop();
        System.out.println(watch.getTotalTimeSeconds()+"");
        watch2.start();
        t2.start();
        watch2.stop();
        System.out.println(watch2.getTotalTimeSeconds()+"");

       /* final SynchronizedTest deno01=new SynchronizedTest();
        for (int i = 0; i < 5; i++) {
            new Thread(deno01::accessResources1).start();
        }*/
        //CountDownLatch
    }
    @Override
    public void run() {
        d1.accessResources();
    }
}

