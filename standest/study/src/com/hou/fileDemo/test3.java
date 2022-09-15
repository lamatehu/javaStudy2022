package com.hou.fileDemo;

import java.io.File;
import java.io.IOException;

public class test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("\\study\\aaa");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
        File file1 = new File("\\study\\aaa\\aaa.txt");
        boolean newFile = file1.createNewFile();
        System.out.println(newFile);

    }
}
