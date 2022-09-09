package com.hou.ip;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class demo1Send {
    // 一直发送 知道输入886停止发送
    public static void main(String[] args) throws IOException {
        //配置发送窗口
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        //配置要发送的数据


        while (true) {
            System.out.println("请输入你要发送的数据：");
            String next = sc.next();

            byte[] bytes1 = next.getBytes();

            InetAddress byName = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length, byName, 63001);
            datagramSocket.send(datagramPacket);

            if (next.equals("886")) {
                System.out.println("结束发送");
                break;
            }

        }
        datagramSocket.close();
    }
}
