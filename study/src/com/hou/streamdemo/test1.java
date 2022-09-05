package com.hou.streamdemo;

import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(List.of("哈路口","三藩市","张三","张反思"));
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (String s : list1){
            if (s.startsWith("张")){
                list2.add(s);
            }
            if (s.length() == 3){
                list3.add(s);
            }
        }
        System.out.println(list1 + "\n"+ list2 + "\n"+list3);
    }
}
