package com.hou.classLoaderDemo;

public class Student {
    public String name;
    public String age;
    public String sex;
    public String score;
    private String aa;

    public String sleep(){
        System.out.println(name + "同学正在睡觉");
        return "我饿了";
    }
    public void eat(){
        System.out.println(name + "正在吃饭");
    }
    private Student(String name){
        this.name = name;
        System.out.println("这是私有方法");
    }


    public Student(String name, String age, String sex, String score) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.score = score;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
