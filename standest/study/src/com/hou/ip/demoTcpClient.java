package com.hou.ip;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class demoTcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 43444);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("啊啊啊，我真的好烦啊".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        int a;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
       while ((line= bufferedReader.readLine()) != null){
           System.out.println(line);
       }
       socket.shutdownInput();
    }
}
