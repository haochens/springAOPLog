package com.springboot.Test.DCL;

/***
 * 懒汉模式，使用到才创建
 */
public class LazySingleton {
    private static  LazySingleton singleton;
    private LazySingleton(){};
    public LazySingleton singleton(){
        if(singleton==null){//多线程时，可能同时进入，实例化多个实例，导致线程不安全
            singleton = new LazySingleton();
        }
        return  singleton;
    }
}
