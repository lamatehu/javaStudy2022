package com.hou.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class outPutStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileS = new FileOutputStream("D:\\a.txt");
        fileS.write(97);
        fileS.close();
    }
}
