package com.hou.threadD;

public class demoThreadaa {
    public static void main(String[] args) {
        demoThread d1 = new demoThread();
        demoThread d2 = new demoThread();
        d1.run();
        d1.start();
        d2.run();
        d2.start();

    }
}
