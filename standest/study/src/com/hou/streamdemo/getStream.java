package com.hou.streamdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class getStream {
    // 四种
    // 单列
    // 多列
    // 集合
    //同种对象

    public static void main(String[] args) {

        //arrayListStream();
        //doubleHashMap();

        int arr[] = {0,1,2,3,4,5};
        Arrays.stream(arr).forEach(s->System.out.println(s));
        Stream.of("aa","bb","dd");
    }

    private static void doubleHashMap() {
        HashMap<String,Integer> has1 = new HashMap<>();
        has1.put("张三",12);
        has1.put("李四",13);
        has1.put("王五",14);
        has1.put("赵六",15);
        has1.put("钱七",16);
        has1.keySet().stream().forEach(s -> System.out.println(s));
        System.out.println("===================");
        has1.entrySet().stream().forEach(s->System.out.println(s));
    }

    public static void arrayListStream() {
        ArrayList<String> list = new ArrayList<>(List.of("张三","李四","王五","赵六","钱七"));
        list.stream().forEach(s -> System.out.println(s));
    }
}
