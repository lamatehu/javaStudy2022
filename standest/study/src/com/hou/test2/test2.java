package com.hou.test2;

public class test2 {
    public static void main(String[] args) {
        s1 s11 = new s1(){


            @Override
            public void print() {
                System.out.println("haha");
            }
        };
        s11.print();
    }
}

interface s1{
    void print();
}
class s1Impl implements s1{

    @Override
    public void print() {
        System.out.println("hahaha");
    }
}
