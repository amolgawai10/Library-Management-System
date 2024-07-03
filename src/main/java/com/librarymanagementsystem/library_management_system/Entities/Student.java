package com.librarymanagementsystem.library_management_system.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity //means schema of how student table will look like
@Table //(name = "student_info") //This annotation will create Table for me // USE bracket syntax to rename table name
@Getter
@Setter
@NoArgsConstructor // This is like Default constructor
@AllArgsConstructor // This is like parameterized constructor
public class Student {

    @Id // StudentId is now Primary key bcz of @Id annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment the PK by system
    private int rollNo;

    @Column(nullable = false) //This annotation can change column name and other properties
    private String name;

    private String branch;

    @Column(nullable = false) // Nullable = false means null is not allow, have to set non - null value
    private Double cgpa;

    @Column(unique = true) // bcz I will make sure all emails should be unique
    private String emailId;

}
