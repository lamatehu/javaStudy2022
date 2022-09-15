package com.hou.characterStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demoObjectStream2 {
    // 使用数组来写入读取对象

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        student s1 = new student("张三", "111001", 18, true);
        student s2 = new student("王四", "111002", 18, true);
        student s3 = new student("李五", "111003", 18, false);

//        ArrayList<student> as = new ArrayList<>(List.of(s1,s2,s3));
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bb.txt"));
//        oos.writeObject(as);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bb.txt"));
         ArrayList<student> af= (ArrayList<student>) ois.readObject();
        for (student student : af) {
            System.out.println(student);
        }
        }


    }

