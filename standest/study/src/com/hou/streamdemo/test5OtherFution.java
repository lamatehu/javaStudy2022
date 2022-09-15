package com.hou.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class test5OtherFution {
    public static void main(String[] args) {
//        limit 截取几个
//        skip 跳过
//        concat 合并两个流
//        distinct 去除流中的两个元素

        ArrayList<String> list = new ArrayList(List.of("张三","张三丰","王二麻子","小文嗯","哈鲁卡","张三丰"));

        Stream list2 = list.stream().limit(2);
        Stream list3 = list.stream().skip(3);
        list.stream().limit(2).forEach(s -> System.out.println(s));
        System.out.println("-----------------------------");
        list.stream().skip(2).forEach(s -> System.out.println(s));
        System.out.println("-----------------------------");
        Stream.concat(list2,list3).forEach(s->System.out.println(s));
        System.out.println("---------------");
        list.stream().distinct().forEach(s -> System.out.println(s));
    }
}
