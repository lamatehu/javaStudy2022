package com.hou.characterStream;

import java.io.Serializable;

public class student implements Serializable {
    public String name;
    public String number;
    public Integer age;
    public boolean sex;
    private final long serialVersionUID = 11l;

    public student(String name, String number, Integer age, boolean sex) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.sex = sex;
    }
    public student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
