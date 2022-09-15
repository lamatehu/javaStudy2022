package com.hou.characterStream;

import java.io.*;

public class demoObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        student wang = new student("小王", "110010", 29, true);
        //writeObject(wang);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bb.txt"));
        student o = (student)ois.readObject();
        System.out.println(o.toString());
        o.name = "小李子";
        System.out.println(o.toString());
        writeObject(o);
    }

    private static void writeObject(student wang) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bb.txt"));
        oos.writeObject(wang);
    }
}
