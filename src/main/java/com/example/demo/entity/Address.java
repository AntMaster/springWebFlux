package com.example.demo.entity;

import com.example.demo.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends BaseEntity {

    private String address;

    private String zipCode;

}
