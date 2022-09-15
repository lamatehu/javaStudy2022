package com.hou.serverPoolDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.concurrent.*;

public class serverDemo {
    public static void main(String[] args) throws IOException {

        //创建线程池
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, //核心线程
                5, //最大线程
                1, //线程存在时间
                TimeUnit.MINUTES, //线程时间单位
                new ArrayBlockingQueue<>(5),//阻塞队列
                Executors.defaultThreadFactory(),   //创建线程方式
                new ThreadPoolExecutor.AbortPolicy());  //任务拒绝策略
        // 创建连接
        ServerSocket ss = new ServerSocket(54200);
        while (true) {
            Socket accept = ss.accept();
            tpe.submit(new ThreadSocket(accept));
        }
//        ss.close();



    }
}
