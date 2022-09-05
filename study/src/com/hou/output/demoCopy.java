package com.hou.output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demoCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\limenyUan\\李梦圆\\2021.03.24+方法精讲-申论3+.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\limenyUan\\李梦圆\\hahahaha.mp4");
        byte[] bytes = new byte[1024];
        int len;
        while ((len =fis.read(bytes) )!=-1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
}
