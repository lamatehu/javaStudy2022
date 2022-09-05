package com.hou.characterStream;

import java.io.*;
import java.util.Scanner;

public class demoBuffer {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("b.txt");
        BufferedReader bfr = new BufferedReader(fr);
        String username = bfr.readLine();
        System.out.println(username);
        String password = bfr.readLine();
        if (username == null && password == null){
            System.out.println("不好意思，现在没有用户信息");
            createUser();
        }

    }

    public static void createUser() throws IOException {
        System.out.println("请输入你的姓名");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        String password = sc.next();
        BufferedWriter bfw = new BufferedWriter(new FileWriter("b.txt"));
        bfw.write(username+"\n");
        bfw.write(password);
        bfw.flush();
        bfw.close();
    }
}
