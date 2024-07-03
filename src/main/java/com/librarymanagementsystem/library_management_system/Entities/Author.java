package com.librarymanagementsystem.library_management_system.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId; // Author Id

    private String name; // Name of Author

    private Integer age; // Age of Author

    private String emailId; // His emailId

    private Double rating; // Rating of Author

    private int noOfBooks; // Number of Books he wrote


}
