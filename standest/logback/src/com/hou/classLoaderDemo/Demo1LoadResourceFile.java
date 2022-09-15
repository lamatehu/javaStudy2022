package com.hou.classLoaderDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class Demo1LoadResourceFile {
    public static void main(String[] args) throws IOException {

        //通过类加载器来读取properties里的东西
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        InputStream resourceAsStream = systemClassLoader.getResourceAsStream("prop.properties");

        Properties ppt = new Properties();
        ppt.load(resourceAsStream);
        System.out.println(ppt);
    }
}
