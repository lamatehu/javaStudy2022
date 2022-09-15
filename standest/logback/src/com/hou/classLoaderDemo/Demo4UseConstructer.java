package com.hou.classLoaderDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo4UseConstructer {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        获取类对象
        Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
//        //获取类
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class, String.class, String.class);
        Student o = (Student)constructor.newInstance("zhangsan", "18", "male", "88");
        System.out.println(o);
        //创建私有构造
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Student o1 = (Student)declaredConstructor.newInstance("zhangsan");
        System.out.println(o1);

    }
}
