package com.hou.fileDemo;

import java.io.File;

public class test4DiGui {
    public static void main(String[] args) {
        File file = new File("D:\\limenyUan\\java\\hello");


        deleteFile(file);


    }

    private static void deleteFile(File file) {
        //先获取文件列表
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()){
                file1.delete();
            }else {
                deleteFile(file1);
            }

            file.delete();
        }

    }
}
