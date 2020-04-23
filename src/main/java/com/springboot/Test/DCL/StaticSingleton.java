package com.springboot.Test.DCL;

import javax.xml.ws.Service;

public class StaticSingleton {
    private class  Singleton{
        StaticSingleton  singleton = new StaticSingleton();
    }
    public StaticSingleton(){}
    public StaticSingleton singleton(){
        return  singleton();
    }

}
