package com.hou.classLoaderDemo;

import java.lang.reflect.Constructor;

public class Demo3GetObject {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
        //获取无参构造
        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);
        //获取有参构造
        Constructor<?> constructor1 = aClass.getConstructor(String.class, String.class, String.class, String.class);
        System.out.println(constructor1);
        //获取构造数组
        Constructor<?>[] constructors = aClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        //可以获取所有构造，但选一个
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        System.out.println(declaredConstructor);
        //获取所有构造 打包成数组
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        System.out.println(declaredConstructors);
    }
}
