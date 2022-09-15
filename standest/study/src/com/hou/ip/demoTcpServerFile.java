package com.hou.ip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class demoTcpServerFile {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(58888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);


        FileOutputStream fileOutputStream = new FileOutputStream("study/copy/1.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        int aa;
        while ((aa = bufferedInputStream.read()) != -1){
            bos.write(aa);
        }
        accept.shutdownInput();

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("已完成".getBytes());
        accept.shutdownOutput();
    }
}
