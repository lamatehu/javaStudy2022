package com.hou.threadD;

public class cook extends Thread {
    public void run(){
        while (true) {
            synchronized (table.lock) {
                if (table.cake == 0) {
                    break;
                } else {
                    if (!table.flag) {
                        //开始制作汉堡
                        System.out.println("大厨正在制作汉堡");
                        table.cake--;
                        //表示现在 桌子上有了
                        table.flag = true;
                        table.lock.notifyAll();
                    } else {
                        try {
                            table.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }

    }
}
