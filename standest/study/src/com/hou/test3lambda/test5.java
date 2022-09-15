package com.hou.test3lambda;

public class test5 {
    public static void main(String[] args) {
        useDoubleAdd((double a,double b,double c)->{
            double aa= a+b;
            int f=(int)(aa +c);
            return (double)f;
        });
    }
    public static void useDoubleAdd(DoubleAdd doubleAdd){
        double result =  doubleAdd.doubleAdd(12.5,13.6,14.7);
        System.out.println(result);
    }
}

interface DoubleAdd{
    Double doubleAdd(double a,double b,double c);
}