package com.hou.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class recive {
    public static void main(String[] args) throws IOException {
        // 设定监听端口
        DatagramSocket datagramSocket = new DatagramSocket(65440);
        byte[] bytes = new byte[1024];
        // 配置接受的大小
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //开始接受数据
        datagramSocket.receive(datagramPacket);
        //获取数据长度 和数据
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        //数据转换
        System.out.println(new String(data,0,length));
        //关闭连接
        datagramSocket.close();
    }
}
