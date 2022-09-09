package com.hou.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class demo1Receive {
    public static void main(String[] args) throws IOException {
        //接受端是个死循环啊
        // 先设置传输接口
        DatagramSocket datagramSocket = new DatagramSocket(63001);
        //再配置接受数据包果
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            String s = new String(data, 0, length);
            System.out.println(new String(data,0,length));
            if (s.equals("886")){
                datagramSocket.close();
                System.out.println("通话结束");
                break;
            }

        }

    }
}
