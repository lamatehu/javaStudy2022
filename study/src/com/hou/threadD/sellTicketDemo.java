package com.hou.threadD;

public class sellTicketDemo implements Runnable{
    private static int TicketNubmber = 100;
    @Override
    public void run() {
        synchronized (this){
            while (true){
                if (TicketNubmber > 0){
                    TicketNubmber --;
                    System.out.println("出票中");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票" + "现在还有" + TicketNubmber);
                }else {
                    System.out.println(Thread.currentThread().getName() + "不好意思，没票了");
                    break;
                }
            }
        }


    }
}
