package com.hou.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class test4Filter {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList(List.of("张三","张三丰","王二麻子"));
        //匿名内部类
        niMingNeiBulei(list);

        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
    }

    public static void niMingNeiBulei(ArrayList<String> list) {
        list.stream().filter(new Predicate<String>() {
                                 @Override
                                 public boolean test(String s) {
                                     return s.startsWith("王");
                                 }
                             }
        ).forEach(s->System.out.println(s));
    }
}
