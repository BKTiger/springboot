package com.zhangtai.demo.index.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangtai
 * @date 2019/1/14 22:49
 * @Description:
 */
@Entity
@Table(name = "student1")
public class Student {

    @Id
    private String id;
    @Column(name = "s_name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "like")
    private String like;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
