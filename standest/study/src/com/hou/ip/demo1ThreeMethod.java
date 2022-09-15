package com.hou.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class demo1ThreeMethod {

    //三种方法
    public static void main(String[] args) throws UnknownHostException {
        //获取ip地址和 网络主机名称
        InetAddress address = InetAddress.getByName("DESKTOP-5MKDOL2");
        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println("hostAddress :" + hostAddress +"\n" +
                "hostName :" + hostName
        );
    }
}
