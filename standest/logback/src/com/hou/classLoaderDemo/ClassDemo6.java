package com.hou.classLoaderDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo6 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class, String.class, String.class);
        Object o = constructor.newInstance("zhangsan", "12", "male", "55");
        Method sleep = aClass.getMethod("sleep");
        Object aa  = sleep.invoke(o);
        System.out.println(aa);

    }
}
