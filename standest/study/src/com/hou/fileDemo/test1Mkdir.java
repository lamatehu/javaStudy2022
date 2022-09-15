package com.hou.fileDemo;

import java.io.File;
import java.io.IOException;

public class test1Mkdir {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\limenyUan\\java\\hello\\nihao\\java\\java.mp3");
//        boolean mkdirs = file.mkdirs();
//        System.out.println(mkdirs);
//
        file.createNewFile();
    }
}
