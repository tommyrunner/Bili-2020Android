package com.example.myapplication.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "tb_user2")
public class UserSqlEntity implements Serializable {
    @DatabaseField()
    String name;
    @DatabaseField()
    String pwd;
    @DatabaseField()
    String age;

    public UserSqlEntity() {
    }

    public UserSqlEntity(String name, String pwd, String age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
