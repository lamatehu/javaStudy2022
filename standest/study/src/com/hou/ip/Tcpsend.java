package com.hou.ip;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcpsend {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54000);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int b;

        while((b = inputStream.read()) !=-1){
            System.out.print((char) b);
        }
        inputStream.close();
        serverSocket.close();
    }
}
