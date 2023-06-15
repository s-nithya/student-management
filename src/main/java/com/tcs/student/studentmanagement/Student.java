package com.tcs.student.studentmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "ROLL_NUMBER")
    private int rollNo;
    private String name;
    private String grade;


}
