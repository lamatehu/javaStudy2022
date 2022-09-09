package com.hou.threadD;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Democallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callableDemo callableDemo = new callableDemo();
        FutureTask<String> ft = new FutureTask<String>(callableDemo);
        Thread tr = new Thread(ft);
        tr.start();
        String s = ft.get();
        System.out.println(s);

    }
}
