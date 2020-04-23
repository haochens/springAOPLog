package com.springboot.Test.synchronizedTest;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * 修饰实例方法，对当前实例对象加锁
 * 修饰静态方法，多当前类的Class对象加锁
 * 修饰代码块，对synchronized括号内的对象加锁
 */
public class SynchronizedTest implements Runnable  {
    private AccessResource ar = new AccessResource();
    public static void main(String[] args) {
         //调用类锁，new新的对象也会锁住
     /*   SynchronizedTest deno01=new SynchronizedTest();
        SynchronizedTest deno02=new SynchronizedTest();
        deno01.accessResources0();
        System.out.println(deno01.hashCode());
        deno02.accessResources0();
        System.out.println(deno02.hashCode());*/
        /**
         * 调用方法锁，加锁的方法上锁，没有synochronized 不同步执行。对象锁时，新new一个对象不会同步
         */

     /*   SynchronizedTest t1 = new SynchronizedTest();
        SynchronizedTest t2 = new SynchronizedTest();
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t2);
        thread1.start();
        thread2.start();*/
        /**
         * 没有加sychronized的方法不管是和对象锁/类锁一起调用都不会被锁
         */
        StopWatch watch = new StopWatch();
        watch.start();
        new Thread(() -> {
            AccessResource.accessResources0();
        }, "B").start();
        new Thread(() -> {
            AccessResource.accessResources();
        }, "A").start();
        watch.stop();
        System.out.println(watch.getTotalTimeSeconds());
    }
    @Override
    public void run() {
    }
}

