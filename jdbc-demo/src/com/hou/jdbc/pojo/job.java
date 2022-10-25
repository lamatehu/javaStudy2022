package com.hou.jdbc.pojo;

public class job {
    int id;
    String jname;
    String description;

    public job(int id, String jname, String description) {
        this.id = id;
        this.jname = jname;
        this.description = description;
    }

    public job() {
    }

    @Override
    public String toString() {
        return "job{" +
                "id=" + id +
                ", jname='" + jname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
