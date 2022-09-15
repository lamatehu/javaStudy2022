package com.hou.test3lambda;
// 该分为 lambda 和 匿名内部类
public class test1 {
    public static void main(String[] args) {
        //匿名内部类
        ss(new inter() {
            @Override
            public void play() {
                System.out.println("哈哈啊");
            }
        });
        ss(()-> {System.out.println("哈哈啊啊啊啊");});
    }
    public static void ss(inter inter){
        inter.play();
    }
}

interface inter{
    void play();
}

