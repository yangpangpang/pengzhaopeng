package com.pengzhaopeng.dbutildemo;

import com.lidroid.xutils.db.annotation.Check;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Unique;

/**
 * Created by 鹏鹏鹏先森 on 2016/1/20.
 */
public class User {

    @Id
    private int id;

    @NotNull
    @Unique
    private String name;

    @Check(value = "20<=age and age<=100")
    private int age;

    @NotNull
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

}
