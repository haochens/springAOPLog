package com.springboot.Test;

public class EnumDL {
    //私有化构造函数
    private EnumDL(){ }

    //定义一个静态枚举类
    enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private EnumDL user;
        //私有化枚举的构造函数
        private SingletonEnum(){
            user=new EnumDL();
        }
        public EnumDL getInstnce(){
            return user;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static EnumDL getInstance(){
        return SingletonEnum.INSTANCE.getInstnce();
    }
}
