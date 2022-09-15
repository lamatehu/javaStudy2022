package com.hou.logbackDemo;

import com.hou.enumDemo.sesson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Demo1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo1.class);
    public static void main(String[] args) {
        System.out.println("aaa");
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        LOGGER.info("用户输入的是"+next);
        System.out.println(sesson.Autumn);
        sesson.Summer.show();
    }
}
