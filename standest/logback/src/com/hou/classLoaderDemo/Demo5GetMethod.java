package com.hou.classLoaderDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo5GetMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类
        Class<Student> studentClass = Student.class;
        //获取方法
        Method eat = studentClass.getMethod("eat");
        //因为要实例，所以创建一个
        Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, String.class, String.class);
        Student student = constructor.newInstance("zhangsan", "18", "male", "88");
        //运行这个方法，并有一个返回值
        Object invoke = eat.invoke(student);
        System.out.println(invoke);

    }
}
