package com.example.demo.entity;

import com.example.demo.entity.base.BaseEntity;
import com.example.demo.enums.SexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author zhang
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseEntity {

    private String username;
    private int age;
    private String password;
    private SexEnum sexEnum;
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles")
    private List<Role> roles;

}
