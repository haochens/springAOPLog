package com.springboot.Test;

public class TryCatch {
    private int i = 0;
    public int getI(){
        try {
            throw  new Exception();
        } catch (Exception e) {
            i++;
            System.out.println("catch"+i);
            return  i;
        }finally {
            i++;
            String a="";
            System.out.println("catch"+i);
        }
    }


    public static void main(String[] args) {
        TryCatch tryCatch = new TryCatch();
        int i = tryCatch.getI();
        System.out.println("返回的数值"+i);
    }



}
