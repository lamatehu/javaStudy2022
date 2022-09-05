package com.hou.fileDemo;

import java.io.File;

public class test2ListFiles {
    public static void main(String[] args) {
        File file = new File("D:\\limenyUan\\");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
