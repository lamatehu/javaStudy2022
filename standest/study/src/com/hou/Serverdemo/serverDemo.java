package com.hou.Serverdemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class serverDemo {
    public static void main(String[] args) throws IOException {
        // 创建连接
        ServerSocket ss = new ServerSocket(54200);
        while (true) {
            Socket accept = ss.accept();
            ThreadSocket threadSocket = new ThreadSocket(accept);
            new Thread(threadSocket).start();
        }
//        ss.close();



    }
}
