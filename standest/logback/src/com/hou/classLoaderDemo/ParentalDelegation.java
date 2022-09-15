package com.hou.classLoaderDemo;

public class ParentalDelegation {
    public static void main(String[] args) {
        //系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //平台类加载器
        ClassLoader parent = systemClassLoader.getParent();
        //启动类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(systemClassLoader);
        System.out.println(parent);
        System.out.println(parent1);
    }
}
