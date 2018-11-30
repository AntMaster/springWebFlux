package com.example.demo.entity;

import com.example.demo.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Role extends BaseEntity {

    private int roleType;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
