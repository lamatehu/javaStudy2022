package com.hou.threadD;

public class DemoRunnable {
    public static void main(String[] args) {
        //第二种
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
        Thread thread1 = new Thread(runnableDemo);
        thread1.start();
    }
}
