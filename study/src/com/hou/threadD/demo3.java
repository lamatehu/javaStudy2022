package com.hou.threadD;

public class demo3 {
    public static void main(String[] args) {
        eat eat = new eat();
        cook cook = new cook();
        cook.start();
        eat.start();

    }
}
