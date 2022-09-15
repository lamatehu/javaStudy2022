package com.hou.anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class mainTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.hou.anno.userPrint");
        Object o = aClass.getDeclaredConstructor().newInstance();
        Method[] Methods = aClass.getDeclaredMethods();
        for (Method method : Methods) {

            System.out.println(method);
            if (method.isAnnotationPresent(test3Anno.class)){
                System.out.println("aa");
                method.invoke(o);
            }

        }


    }
}
