package com.hou.propertiesDemo;

import java.io.*;
import java.util.Properties;

public class demo2Properties {

    public static void main(String[] args) throws IOException {
        //先 读取 properties
        Properties pron = new Properties();
        FileReader fr = new FileReader("study/prop.properties");
        pron.load(fr);
        System.out.println(pron);
        fr.close();
        // 再写入

        pron.put("sex","男");
        pron.put("age","18");
        FileWriter fw = new FileWriter("study/prop.properties");
        pron.store(fw,"个人信息");
        fw.close();
    }
}
