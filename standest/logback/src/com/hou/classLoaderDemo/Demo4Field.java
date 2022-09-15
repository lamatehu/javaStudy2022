package com.hou.classLoaderDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo4Field {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> studentClass = Student.class;
        Field name = studentClass.getField("name");
        System.out.println(name);

        //创建对象赋值
        Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, String.class, String.class);
        Student student = constructor.newInstance("zhangsan", "18", "male", "88");
        //把对象的值修改
        name.set(student,"sanfan");
        //获取student中这个对象的值
        Object o = name.get(student);
        System.out.println(o);
        System.out.println(student.toString());

    }
}
