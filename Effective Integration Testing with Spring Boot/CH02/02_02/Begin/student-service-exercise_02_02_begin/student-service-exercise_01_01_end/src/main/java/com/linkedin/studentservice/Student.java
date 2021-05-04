package com.linkedin.studentservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean active;
    private Integer grade;

    public Student() {

    }
}
