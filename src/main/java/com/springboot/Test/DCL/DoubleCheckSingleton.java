package com.springboot.Test.DCL;

/**
 * 双重监测加锁，先检测是否为空，为空加锁，再次检测是否为空，为空创建实例
 *
 * 不但保证了单例，而且切实提高了程序运行效率
 */
public class DoubleCheckSingleton {
    private static DoubleCheckSingleton singleton ;
    private DoubleCheckSingleton(){};
    public  static  DoubleCheckSingleton singleton(){
        //先判断是否存在，不存在再加锁处理
        if(singleton==null){
            //在同一个时刻加了锁的那部分程序只有一个线程可以进入
            synchronized (singleton){
                if(singleton==null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }

        return  singleton;
    }
}
