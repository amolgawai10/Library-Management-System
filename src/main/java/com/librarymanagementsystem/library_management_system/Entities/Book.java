package com.librarymanagementsystem.library_management_system.Entities;

import com.librarymanagementsystem.library_management_system.Enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId; // Book Id

    @Column(unique = true)
    private String title; // Title of Book

    private Integer noOfPages; // No of pages

    @Enumerated(value = EnumType.STRING)
    private Genre genre; // Book Genre

    private Integer price; // Price of Book

    private Boolean isIssued;

    @JoinColumn // FK always be in child table and create one extra column where author id is there.
    @ManyToOne // mention Book entity relation with Author entity
    private Author author;
}
