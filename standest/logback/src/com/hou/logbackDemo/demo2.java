package com.hou.logbackDemo;

import com.hou.enumDemo.sesson;
import jdk.jshell.execution.Util;

public class demo2 {
    public static void main(String[] args) {
        //name 打印名称
        System.out.println(sesson.Summer.name());
        //获取枚举索引
        int ordinal = sesson.Winter.ordinal();
        //比较两者的索引差值
        int i = sesson.Autumn.compareTo(sesson.Summer);
        //打印
        String s = sesson.Autumn.toString();
        System.out.println(s);
        //通过类加载的方式获得对象
        sesson autume = Enum.valueOf(sesson.class, "Autumn");
        System.out.println(autume.name());
        //获取枚举类的所有对象
        sesson[] values = sesson.values();
        for (int i1 = 0; i1 < values.length; i1++) {
            System.out.println(values[i1].name());
        }
    }
}