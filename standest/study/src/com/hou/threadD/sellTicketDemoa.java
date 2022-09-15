package com.hou.threadD;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class sellTicketDemoa {
    private static ReentrantLock  locks = new ReentrantLock();

    public static void main(String[] args) {
        sellTicketDemo sellTicketDemo = new sellTicketDemo();
        Thread thread = new Thread(sellTicketDemo);
        Thread thread1 = new Thread(sellTicketDemo);
        Thread thread2 = new Thread(sellTicketDemo);




        thread.setName("一号窗口");
        thread1.setName("二号窗口");
        thread2.setName("三号窗口");

        thread.start();
        thread1.start();
        thread2.start();


    }

    public static synchronized void ss(){

        System.out.println();
    }
}
