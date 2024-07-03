package com.librarymanagementsystem.library_management_system.Repositories;

import com.librarymanagementsystem.library_management_system.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {

}
