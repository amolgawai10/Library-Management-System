package com.librarymanagementsystem.library_management_system.Services;

import com.librarymanagementsystem.library_management_system.Entities.Author;
import com.librarymanagementsystem.library_management_system.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public String addAuthor(Author author){

        author.setNoOfBooks(0); // Setting the default value as 0 and not null
        authorRepository.save(author);
        return "Author has been saved to the DB";
    }
}
