package com.hou.edu.info.domain;

public class Person {
    private String name;
    private String id;
    private String age;
    private String birthday;


    public Person(String name, String id, String age, String birthday) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.birthday = birthday;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}

