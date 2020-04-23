package com.springboot.Test;

import java.time.Duration;
import java.time.Instant;

public class VolatileTest extends Thread{
  /*  public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
       // Instant start = Instant.now();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
       // Instant end = Instant.now();
        //long timeElapsed = Duration.between(start, end).toMillis(); // 单位为毫秒

        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }*/
      public   static volatile int a=0;
      public void run() {
          a=2;
      }
      public static void main(String[] args) {
          // TODO Auto-generated method stub
          VolatileTest array[]=new VolatileTest[100];
          for (int i = 0; i < array.length; i++) {
              array[i]=new VolatileTest();
              array[i].start();
              System.out.print(array[i].a+" ");
          }
      }
}