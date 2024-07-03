package com.librarymanagementsystem.library_management_system.Repositories;

import com.librarymanagementsystem.library_management_system.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {

}
