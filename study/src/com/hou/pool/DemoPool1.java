package com.hou.pool;


import java.util.concurrent.*;

public class DemoPool1 {

    public static void main(String[] args) throws InterruptedException {
        easyPool();
        standest();

        hard();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, //固定线程数
                3, //最大线程数
                8,      // 空闲线程等待时间数
                TimeUnit.SECONDS,   //  等待时间单位
                new ArrayBlockingQueue<>(5),    //等待队列长度
                Executors.defaultThreadFactory(),       //线程池创建方式 （默认）
                new ThreadPoolExecutor.AbortPolicy());  //线程拒绝策略

    }
    //这个是用底层的线程创建方式创建的
    private static void hard() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈啊");
            }
        });
        threadPoolExecutor.shutdown();
    }

    //这个方法稍微有点复杂，但是还是换汤不换药
    private static void standest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
            System.out.println("钓鱼时间到了");
        });
        Thread.sleep(2000);
        executorService.submit(()->{
            System.out.println("人在塔在");
        });
        executorService.shutdown();
    }

    //这个方法定义了一个线程池，submit方法是当想要使用一个线程的时候，系统自动生成一个线程，用完之后自动的回收
    private static void easyPool() {
        //这里没有定义最多可以有多少个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println(Thread.currentThread() + "线程正在行动");
                });
        executorService.submit(()->{
           System.out.println(Thread.currentThread() + "正在行动");
        });
        executorService.shutdown();
        System.out.println("线程结束");
    }
}
