package com.librarymanagementsystem.library_management_system.Controllers;

import com.librarymanagementsystem.library_management_system.Entities.Book;
import com.librarymanagementsystem.library_management_system.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        String result = bookService.addBook(book);
        return result;
    }

    @PutMapping("/associateBookAndAuthor")
    public String associateBookAndAuthor(@RequestParam("bookId") Integer bookId,
        @RequestParam("authorId")Integer authorId){

        String result = bookService.associateBookAndAuthor(bookId,authorId);
        return result;
    }
}
