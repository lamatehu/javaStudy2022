package com.hou.classLoaderDemo;

public class Demo2Loader3Method {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一个通过forname加载
        Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
        System.out.println(aClass);
        //第二种通过getclass类加载
        Student student = new Student();
        Class aClass1 = student.getClass();
        System.out.println(aClass1);
        //第三种通过类名加class来加载
        Class<Student> studentClass = Student.class;

    }
}
