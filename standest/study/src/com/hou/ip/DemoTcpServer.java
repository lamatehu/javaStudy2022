package com.hou.ip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DemoTcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(43444);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        accept.shutdownInput();
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("你在干什么".getBytes(StandardCharsets.UTF_8));
        accept.shutdownOutput();
    }
}
