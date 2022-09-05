package com.hou.edu.info.entry;

import com.hou.edu.info.controller.StudentController;

import java.util.Scanner;

public class infoManagerEntry {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("----欢迎来到小猴子教育管理系统----");
            System.out.println("请输入您的选择: 1.学生管理 2.老师管理 3.退出");
            String nc = sc.next();
            switch (nc){
                case "1":
                    System.out.println("进入学生管理");
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("进入老师管理");
                    break;
                case "3":
                    System.out.println("再见");
                    System.exit(0);
                    sc.close();
                    break;
            }
        }

    }
}
