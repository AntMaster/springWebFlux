package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.enums.SubjectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author zhang
 */
@RestController
public class Controller {

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;

    private final ArticleRepository articleRepository;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    @Autowired
    public Controller(TeacherRepository teacherRepository, StudentRepository studentRepository, ArticleRepository articleRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    
    @GetMapping("/articles/{id}")
    public Article getArticles(@PathVariable int id) {
        return articleRepository.findById(id).orElse(null);
    }
    
/*
    @GetMapping("/articles/{id}")
    public Article getArticles(@PathVariable int id) {
        articleRepository.findById(id);
        return null;
    }

    @PostMapping("/teacherRelationStudent")
    public Teacher teacherRelationStudent() {
        Teacher teacher = new Teacher();
        teacher.setSalary(123.3454);
        teacher.setSubjectEnums(SubjectEnum.LANGUAGE);
        teacher.setAvailable(false);
        return teacherRepository.save(teacher);
    }

    @PostMapping("/teacher")
    public Teacher saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setSalary(123.3454);
        teacher.setSubjectEnums(SubjectEnum.LANGUAGE);
        teacher.setAvailable(false);

        Student student = new Student();
        student.setGrade(1);
        student.setClasses(2);
        student.setScore(123);
        studentRepository.save(student);

      *//*  List<Student> students = new ArrayList<>();
        students.add(student);
        teacher.setStudents(students);
*//*
        return teacherRepository.save(teacher);
    }

    @PostMapping("/student")
    public Student saveStudent() {
        Student student = new Student();
        student.setGrade(1);
        student.setClasses(2);
        student.setScore(123);

        return studentRepository.save(student);
    }

    @GetMapping("/teacher")
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/student")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }


    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable int id) {
        return studentRepository.findById(id).get();
    }

    @GetMapping("/teachers/{id}")
    public User getTeachers(@PathVariable int id) {
        return teacherRepository.findById(id).get();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable int id) {
        return userRepository.findById(id).get();
    }
    @GetMapping("roles/{id}")
    public Role getRoles(@PathVariable int id){
        return roleRepository.findById(id).get();
    }*/

}
