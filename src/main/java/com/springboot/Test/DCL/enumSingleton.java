package com.springboot.Test.DCL;

public enum  enumSingleton {
    INSTANCE;
    private String useName;

    public String doSomething() {
        return INSTANCE.useName;
    }

}
