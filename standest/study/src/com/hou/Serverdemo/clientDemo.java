package com.hou.Serverdemo;

import java.io.*;
import java.net.Socket;

public class clientDemo {
    public static void main(String[] args) throws IOException {
        Socket sk = new Socket("127.0.0.1",54200);

        // 文件获取
        FileInputStream fl = new FileInputStream("study/img/IMG_20200530_152020.jpg");
        // 传输通道建立
        int read = fl.read();
        System.out.println(read);
        OutputStream oS = sk.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(oS);
        int b;
        while ((b = fl.read()) != -1){
            bos.write(b);
        }
        bos.flush();
        // 关闭传输流
        sk.shutdownOutput();
        // 获取是否传输成功的信息
        InputStream inputStream = sk.getInputStream();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
        String aa;
        while ((aa = bfr.readLine()) != null){
            System.out.println(aa);
        }
        sk.shutdownInput();

        //关闭流
        oS.close();

        bos.close();


        fl.close();


        bfr.close();
        inputStream.close();


    }
}
