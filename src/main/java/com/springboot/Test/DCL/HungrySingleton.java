package com.springboot.Test.DCL;

/***
 * 单例饿汉模式
 * 只实例化一次，线程安全
 */
public class HungrySingleton {
    private static  HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){};
    public static HungrySingleton singleton(){
        return  hungrySingleton;
    }
}

