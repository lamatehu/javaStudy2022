package com.hou.test2;

public class cook extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (table.locks){
                if (table.cake == 0){
                    break;
                }else {
                    if (!table.flag){
                        System.out.println("大厨正在制作蛋糕");
                        table.cake --;
                        table.flag = true;
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
