package com.hou.characterStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class demoUser {

    public static void main(String[] args) throws IOException {
        File fl = new File("b.txt");
        FileWriter fla = new FileWriter(fl);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String username = sc.next();
        System.out.println("密码");
        String password = sc.next();
        System.out.println(username + "\n" + password);
        fla.write(username +"\n");
        fla.write(password);
        fla.close();



    }
}
