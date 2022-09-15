package com.hou.characterStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class demoFileWrite {
    public static void main(String[] args) throws IOException {
        File fl = new File("D:\\java2022\\study\\src\\com\\hou\\characterStream\\a.txt");
        System.out.println(fl.getPath());
//        char[] aa = {1,33,77,66};
        FileWriter fla = new FileWriter(fl);
        String aa = "哈哈哈";
        fla.write(aa);
        fla.close();


        //fw.write(String.valueOf(aa));
    }
}
