package com.hou.fileDemo;

import java.util.UUID;

public class jj {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().replace("-","");
        System.out.println(s);
    }
}
