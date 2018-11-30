package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhang
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
