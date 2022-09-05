package com.hou.test3lambda;

public class test4 {
    public static void main(String[] args) {
        useTwoNumberAdd(new TwoNumberAdd() {
            @Override
            public int addTwo(int a, int b) {
                return a+b;
            }
        });
        useTwoNumberAdd((int a,int b)->{return a+b;});
    }
    public static void useTwoNumberAdd(TwoNumberAdd twoNumberAdd){
        int result = twoNumberAdd.addTwo(10,20);
        System.out.println(result);
    }
}

interface TwoNumberAdd{
    int addTwo(int a,int b);
}