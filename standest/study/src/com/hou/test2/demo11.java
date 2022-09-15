package com.hou.test2;

public class demo11 {
    //实现生产者
    public static void main(String[] args) {
        cook cook = new cook();
        eat eat = new eat();
        cook.start();
        eat.start();
    }
}
