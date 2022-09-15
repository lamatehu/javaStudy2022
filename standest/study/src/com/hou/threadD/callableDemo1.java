package com.hou.threadD;

import java.util.concurrent.Callable;

public class callableDemo1 implements Callable {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread() + "---" + i);
        }
        return Thread.currentThread() + "完成了";
    }
}
