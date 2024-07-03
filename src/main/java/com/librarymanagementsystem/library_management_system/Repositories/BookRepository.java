package com.librarymanagementsystem.library_management_system.Repositories;

import com.librarymanagementsystem.library_management_system.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
