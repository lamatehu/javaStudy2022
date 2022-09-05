package com.hou.output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\limenyUan\\hahahaha.txt");
        while (fis.read() != -1){
            int read = fis.read();
            System.out.println((char)read);

        }
        fis.close();
    }
}
