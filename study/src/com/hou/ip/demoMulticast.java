package com.hou.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

public class demoMulticast {
    public static void main(String[] args) throws IOException {
        send();
        MulticastSocket multicastSocket = new MulticastSocket(60002);
        multicastSocket.joinGroup(InetAddress.getByName("224.0.0.21"));
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        multicastSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data));

    }

    private static void send() throws IOException {
        MulticastSocket multicastSocket = new MulticastSocket();
        InetAddress byName = InetAddress.getByName("224.0.0.21");
        String s = "哈哈啊哈";
        DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), s.getBytes().length, byName, 60002);
        multicastSocket.send(datagramPacket);
        multicastSocket.close();
    }

}
