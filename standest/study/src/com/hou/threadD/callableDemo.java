package com.hou.threadD;

import java.util.concurrent.Callable;

public class callableDemo implements Callable {

    @Override
    public String call() throws Exception {
        for (int i =0;i<=100;i++){
            System.out.println(i + "这是callable");
        }
        return "aaa";
    }
}
