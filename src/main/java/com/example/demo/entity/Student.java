package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author zhang
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Student extends User {

    /**
     * 年级
     */
    private int grade;

    /**
     * 班级
     */
    private int classes;

    /**
     * 分数
     */
    private int score;

    /**
     * 家庭住址
     */
    @OneToOne
    private Address address;

    /**
     * 写的文章
     */
    @OneToMany(mappedBy = "student")
    private List<Article> articles;


    /**
     * 授课老师
     */
    @ManyToMany(mappedBy = "students")
    List<Teacher> teachers;
}
