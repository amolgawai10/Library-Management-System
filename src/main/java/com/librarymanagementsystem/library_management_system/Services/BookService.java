package com.librarymanagementsystem.library_management_system.Services;

import com.librarymanagementsystem.library_management_system.Entities.Author;
import com.librarymanagementsystem.library_management_system.Entities.Book;
import com.librarymanagementsystem.library_management_system.Repositories.AuthorRepository;
import com.librarymanagementsystem.library_management_system.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    public String addBook(Book book){
        bookRepository.save(book);
        return "Book has been saved to the DB";
    }

    public String associateBookAndAuthor(Integer bookId, Integer authorId){

        //fetch entity from DB by id
        Book book = bookRepository.findById(bookId).get();
        Author author = authorRepository.findById(authorId).get();

        //update and then put into database just like Hashmap

        //Step 1: Associate book and author entity
        book.setAuthor(author);
        //update book count for author
        author.setNoOfBooks(author.getNoOfBooks()+1); // if book is associated to author, BookCount++

        //Step 2 : Put updated entities in DB
        bookRepository.save(book);
        authorRepository.save(author);

        return "Book and Author have been Associated";
    }
}
