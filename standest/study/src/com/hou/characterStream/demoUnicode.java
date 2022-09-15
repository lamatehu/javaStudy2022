package com.hou.characterStream;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class demoUnicode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String aa = "你好啊，我很好哦，哈啊哈";
        byte[] bytes = aa.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = aa.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));
        String s = new String(bytes);
        System.out.println(s);
        String gbk = new String(bytes1, "GBK");
        System.out.println(gbk);
    }
}
