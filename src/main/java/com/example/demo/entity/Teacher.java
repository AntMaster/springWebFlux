package com.example.demo.entity;

import com.example.demo.enums.SubjectEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

/**
 * @author zhang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Teacher extends User {


    /**
     * 学科
     */
    private SubjectEnum subjectEnums;

    /**
     * 薪水
     */
    private double salary;

    /**
     * 老师所教的学生
     */
    @ManyToMany
    /* 可加可不加
   @JoinTable(name = "teacher_student",//中间表名
            joinColumns = @JoinColumn(name = "teacher_id"),//关系由老师表来维护
            inverseJoinColumns = @JoinColumn(name = "student_id"))*/
    private List<Student> students;
}
