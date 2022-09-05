package com.hou.test3lambda;

import java.util.Random;

public class test3 {
    public static void main(String[] args) {
        getRandom(new randomNumber() {
            @Override
            public int ResultRandom() {
                Random random = new Random();
                int number = random.nextInt(10)+1;
                return number;
            }
        });
        getRandom(()->{
            Random random = new Random();
            double number = random.nextDouble();
            return (int)number;
        });
    }
    public static void getRandom(randomNumber randomNumber ){

        System.out.println(randomNumber.ResultRandom());
    }
}

interface randomNumber{
    int ResultRandom();
}