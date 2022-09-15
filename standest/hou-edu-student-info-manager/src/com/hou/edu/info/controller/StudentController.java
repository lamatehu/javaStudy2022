package com.hou.edu.info.controller;

import com.hou.edu.info.domain.Student;
import com.hou.edu.info.service.StudentService;

import java.util.Scanner;

public class StudentController {
    Scanner sc = new Scanner(System.in);
    StudentService studentService = new StudentService();
    public void start() {
        studentchoice :while  (true){
            System.out.println("---欢迎来到学生管理系统---");
            System.out.println("1. 添加学生 2.删除学生 3.修改学生 4.查询学生 5.返回上级");
            String choice  = sc.next();
            switch (choice){
                case "1":
                    System.out.println("进入添加学生");
                    addStudent();
                    break;
                case "2":
                    System.out.println("进入删除学生");
                    deleteStudentByid();
                    break;
                case "3":
                    System.out.println("进入修改学生");
                    fixStudent();
                    break;
                case "4":
                    System.out.println("进入查询学生");
                    break;
                case "5":
                    System.out.println("返回上级");
                    break studentchoice;
                default:
                    System.out.println("对不起输入错误请重新输入");
            }
        }

    }

    public void fixStudent() {
        System.out.println("请输入你想修改的id");
        String fixid = sc.next();
        boolean isexit = studentService.isExist(fixid);
        if (!isexit){
            System.out.println("不好意思，没有");
            return;
        }
        Student newstu= new Student();
        System.out.println("请输入你的学号");
        String id= sc.next();
        System.out.println("请输入你的名称");
        String name = sc.next();
        System.out.println("请输入你的生日");
        String birthday = sc.next();
        System.out.println("请输入你的年龄");
        newstu.setId(id);
        newstu.setName(name);
        newstu.setBirthday(birthday);

        studentService.fixStudent(id,newstu);


    }

    public void deleteStudentByid() {
        Student[] stus = studentService.findAllStudent();
        if (stus == null){
            System.out.println("不好意思，啥也没有，别查了");
            return;
        }
        System.out.println("请输入你想删除的id");
        String id = sc.next();

        boolean isExist =  studentService.isExist(id);
        if (isExist){
            System.out.println("存在正在删除");
            studentService.deleteStudentByid(id);
        }else{
            System.out.println("不好意思不存在");
        }
    }

    public void addStudent() {
        StudentService studentService = new StudentService();
        //添加学生
        Student stu = new Student();
        String id;
        Scanner sc = new Scanner(System.in);
        studentNumber:while (true){
            System.out.println("请输入学生id");
            id = sc.next();
            //如果id存在 则为true
            boolean idflag = studentService.isExist(id);
            System.out.println(idflag);
            if (idflag == true){
                System.out.println("不好意思id已经存在"+id+" 取消添加请回复q");

            }else {

                break studentNumber;
            }
        }


        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生年龄");
        String age = sc.next();
        System.out.println("请输入学生生日");
        String birthday = sc.next();
        //封装对象
        stu.setId(id);
        stu.setAge(age);
        stu.setName(name);
        stu.setBirthday(birthday);

        boolean flag  = studentService.addStudent(stu);
        if (flag  == true) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加不成功");
        }


    }
}
