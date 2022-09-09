package com.hou.threadD;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo1Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callableDemo1 callableDemo1 = new callableDemo1();
        FutureTask<String> stringFutureTask = new FutureTask<String>(callableDemo1);
        FutureTask<String> stringFutureTask1 = new FutureTask<String>(callableDemo1);

        //调度 方法

        Thread thread = new Thread(stringFutureTask);
        Thread thread1 = new Thread(stringFutureTask1);

        thread.setPriority(6);
        thread.setName("老虎");
        thread.start();
        String s = stringFutureTask.get();
        System.out.println(s);


        thread1.setPriority(7);
        thread1.setName("绵羊");
        thread1.start();


        System.out.println(stringFutureTask1.get());


    }
}
