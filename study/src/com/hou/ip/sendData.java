package com.hou.ip;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class sendData {
    public static void main(String[] args) throws IOException {
        send();
    }


    private static void send() throws IOException {
        //udp 发送数据
        //1. 创建连接
        DatagramSocket datagramSocket = new DatagramSocket();
        //2.设置要发送的数据
        String msg = "老师您号，我是哈哈啊哈";
        byte[] bytes = msg.getBytes();
        InetAddress address =InetAddress.getByName("127.0.0.1");
        //3. 配置包裹
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, 65440);
        //4. 发送包裹
        datagramSocket.send(datagramPacket);
    }
}
