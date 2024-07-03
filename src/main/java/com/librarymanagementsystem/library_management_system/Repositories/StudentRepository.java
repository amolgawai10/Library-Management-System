package com.librarymanagementsystem.library_management_system.Repositories;
import com.librarymanagementsystem.library_management_system.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
