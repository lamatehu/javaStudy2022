package com.hou.output;

import java.io.*;

public class demoBuffereadInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream ris = new FileInputStream("D:\\limenyUan\\java\\01-案例驱动教学模式介绍【海量 资源：666java.com】.flv");
        FileOutputStream ros = new FileOutputStream("D:\\limenyUan\\java\\012.flv");
        BufferedInputStream bis = new BufferedInputStream(ris);
        int b;
        while ((b= bis.read()) != -1){
            ros.write(b);
        }

    }
}
