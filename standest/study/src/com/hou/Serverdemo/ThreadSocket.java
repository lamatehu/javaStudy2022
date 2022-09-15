package com.hou.Serverdemo;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable {
    private final Socket accept;

    public ThreadSocket(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        BufferedOutputStream bos = null;

        try {
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

            //自动将文件重命名 uuid
            String s = UUID.randomUUID().toString().replace("-", "");

             bos = new BufferedOutputStream(new FileOutputStream("study/copy/" + s + ".jpg"));


            int aa;
            while ((aa = bis.read()) != -1) {
                bos.write(aa);
            }
            //传输成功候关闭连接
            accept.shutdownInput();


            //传输接受成功的信息
            System.out.println("开始传输信息");
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("传输成功".getBytes());
            accept.shutdownOutput();

            System.out.println("传输完成");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭连接
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
