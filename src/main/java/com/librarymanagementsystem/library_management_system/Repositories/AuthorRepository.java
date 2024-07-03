package com.librarymanagementsystem.library_management_system.Repositories;

import com.librarymanagementsystem.library_management_system.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
