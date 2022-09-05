package com.hou.streamdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class test7CollectStream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList(List.of("张三","张三丰","王二麻子","小文嗯","哈鲁卡","张三丰"));
      List list1 =  list.stream().filter(s -> s.endsWith("三")).collect(Collectors.toList());
      System.out.println(list1);
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list3.add(i);
        }
        Set<Integer> ss=  list3.stream().filter(s->s%2 == 0).collect(Collectors.toSet());
        System.out.println(ss);
    }
}
