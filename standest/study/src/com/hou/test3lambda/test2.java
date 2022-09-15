package com.hou.test3lambda;

public class test2 {
    public static void main(String[] args) {
        // 匿名内部类
        printss(new Ss() {
            @Override
            public void printlambda(String msg) {
                System.out.println("你好");
            }
        });

        //lambda

        printss((String msg)->{System.out.println(msg + "匿名内部类");});
    }

    public static void printss(Ss ss){
        ss.printlambda("你好");
    }
}


interface Ss {
     void printlambda(String msg);
}