package com.hou.test2;

public class eat extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (table.locks){
                if (table.cake== 0){
                    break;
                }else {
                    if (table.flag){
                        //现在桌子上有就开吃
                        System.out.println("客人正在吃汉堡");
                        table.flag = false;
                        table.locks.notifyAll();
                    }else{
                        try {
                            table.locks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
