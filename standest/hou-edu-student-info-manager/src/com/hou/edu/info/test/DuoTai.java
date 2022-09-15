package com.hou.edu.info.test;

public class DuoTai {
    public static void main(String[] args) {
        useduotai(new Cat());
        useduotai(new Dog());
    }
    public static void useduotai(Animal animal){

        if (animal instanceof Dog){
            Dog i = (Dog)animal;

            i.sound();
        }
        animal.eat();


    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
class Animal{
    public void eat(){
        System.out.println("吃啊吃啊");
    }
        }
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
    public void sound(){
        System.out.println("汪汪汪");
    }
}