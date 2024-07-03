package com.librarymanagementsystem.library_management_system.Services;

import com.librarymanagementsystem.library_management_system.Entities.Book;
import com.librarymanagementsystem.library_management_system.Entities.LibraryCard;
import com.librarymanagementsystem.library_management_system.Entities.Transaction;
import com.librarymanagementsystem.library_management_system.Enums.TransactionStatus;
import com.librarymanagementsystem.library_management_system.Repositories.BookRepository;
import com.librarymanagementsystem.library_management_system.Repositories.CardRepository;
import com.librarymanagementsystem.library_management_system.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public static Integer MAX_NO_OF_ISSUED_BOOK = 3;

    public String issueBook(Integer cardId, Integer bookId) throws Exception{

        //find book and card from repository

        //create transaction object

        //set relevant attributes of TransactionObject

        //Change the attributes of card and book entity
        Transaction transaction = new Transaction();

        //1.Book should be valid
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if(bookOptional.isEmpty()){
            throw new Exception("BookId is incorrect");
        }

        Book book = bookOptional.get();
        //Book book = bookRepository.findById(bookId).get();

        //2.Library Card should be valid
        Optional<LibraryCard> libraryCardOptional = cardRepository.findById(cardId);

        if(libraryCardOptional.isEmpty()){
            throw new Exception("CardId is incorrect");
        }

        LibraryCard card = libraryCardOptional.get();
        //LibraryCard card = cardRepository.findById(cardId).get();


        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        //3.Book should not be already issued
        if(book.getIsIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "Book is already issued to cardId "+card.getCardNo();
        }

        //4.Limit of card exceeded
        if(card.getNoOfBooksIssued() > MAX_NO_OF_ISSUED_BOOK){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "Max Limit of this card has exceeded";
        }

        //5.Check if card expired its validity
        Long timeInMsOfCardValidity = card.getValidity().getTime();
        Long currentTimeInMs = System.currentTimeMillis();

        if(currentTimeInMs>timeInMsOfCardValidity){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "The card has been expired";
        }

        //Happy flow : Here issuing book logic is done

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIsIssued(true);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        //Rule is updated things will save now
        cardRepository.save(card);
        bookRepository.save(book);
        transaction = transactionRepository.save(transaction);
        return "The Transaction has been completed with TransactionId "+transaction.getTransactionId();
    }
}
