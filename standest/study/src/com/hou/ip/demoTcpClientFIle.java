package com.hou.ip;

import java.io.*;
import java.net.Socket;

public class demoTcpClientFIle {
    //文件传输
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("study/img/IMG_20200530_152020.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        Socket socket = new Socket("127.0.0.1", 58888);
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int b;
        while ((b = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(b);
        }
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String aa;
        while ((aa = bufferedReader.readLine())!=null){
            System.out.println(aa);
        }
        socket.shutdownInput();

    }
}
