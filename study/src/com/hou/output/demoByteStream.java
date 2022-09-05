package com.hou.output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demoByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream ris = new FileInputStream("D:\\limenyUan\\java\\01-案例驱动教学模式介绍【海量 资源：666java.com】.flv");
        FileOutputStream ros = new FileOutputStream("D:\\limenyUan\\java\\012.flv");
        byte[] bytes = new byte[1024];
        int len = 0;
        int b;
        while ((len= ris.read(bytes))!=-1){
            ros.write(bytes,0,len);
        }
        ris.close();
        ros.close();
    }

}
