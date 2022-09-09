package com.hou.threadD;

public class eat extends Thread{
    public void run(){
        System.out.println("现在的汉堡数"+ table.cake);
        //首先先进入循环
        while (true) {
            synchronized (table.lock) {

                //判断桌子上还有没有
                if (table.cake == 0) {
                    break;
                } else {
                    if (table.flag) {
                        System.out.println("现在正在吃汉堡");
                        table.flag = false;
                        table.lock.notifyAll();
                    } else {
                        //没有汉堡只能等待
                        try {
                            table.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }}}


