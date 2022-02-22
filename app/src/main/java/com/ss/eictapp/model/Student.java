package com.ss.eictapp.model;

public class Student {
    private String sname;
    private int id;
    private String branch;
    private int age;
    private String imageUrl;
    public Student()
    {

    }

    public Student(String sname, int id, String branch, int age, String imageUrl) {
        this.sname = sname;
        this.id = id;
        this.branch = branch;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
