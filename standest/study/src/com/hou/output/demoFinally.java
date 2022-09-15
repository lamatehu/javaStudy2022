package com.hou.output;

import java.io.FileOutputStream;


public class demoFinally {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\limenyUan\\Wireshark\\aa.txt");
            fos.write(99);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
