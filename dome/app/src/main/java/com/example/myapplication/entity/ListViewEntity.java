package com.example.myapplication.entity;

public class ListViewEntity {
    String name;
    int age;

    public ListViewEntity() {
    }

    public ListViewEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ListViewEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
