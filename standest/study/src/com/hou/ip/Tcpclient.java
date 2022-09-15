package com.hou.ip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Tcpclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 54000);
        OutputStream outputStream = socket.getOutputStream();
        String aa = "aaa";
        outputStream.write(aa.getBytes());
        outputStream.close();
        socket.close();

    }
}
