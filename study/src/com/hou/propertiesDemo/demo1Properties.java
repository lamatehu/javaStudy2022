package com.hou.propertiesDemo;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class demo1Properties {
    public static void main(String[] args) {
        //关于properties用于map的方法
        Properties pron = new Properties();

        // 写入
        pron.put("学生","老师");
        pron.put("工人","领导");
        //删除
        pron.remove("工人");
        //修改 使用put方法
        pron.put("学生","大学生");
        //查询
        pron.get("学生");

        // 两种遍历方式
        Set<Object> objects = pron.keySet();
        for (Object key : objects) {
            System.out.println(key);
            System.out.println(pron.get(key));
        }
        // 获取 键值对

        Set<Map.Entry<Object, Object>> entries = pron.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            System.out.println(key +" = "+value);
        }
    }
}
