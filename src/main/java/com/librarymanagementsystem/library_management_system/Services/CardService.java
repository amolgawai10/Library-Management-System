package com.librarymanagementsystem.library_management_system.Services;

import com.librarymanagementsystem.library_management_system.Enums.CardStatus;
import com.librarymanagementsystem.library_management_system.Entities.LibraryCard;
import com.librarymanagementsystem.library_management_system.Entities.Student;
import com.librarymanagementsystem.library_management_system.Repositories.CardRepository;
import com.librarymanagementsystem.library_management_system.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;
    public String generateCard(){

        // I want to save Library card in my Db, first generate the Card
        LibraryCard card = new LibraryCard(); //This obj will go inside DB and save it
        card.setCardStatus(CardStatus.NEW);
        card.setNoOfBooksIssued(0);
        Date expiryDate = new Date(2024,6,1);
        card.setValidity(expiryDate);
        card = cardRepository.save(card);
        //saving card in repo // after saving entity we get entity also

        return "The card has been generated with cardId "+card.getCardNo();
    }

    public String associateCardandStudent(Integer cardId, Integer studentId){

        LibraryCard libraryCard = cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();

        libraryCard.setCardStatus(CardStatus.ISSUED);
        libraryCard.setStudent(student);//Indirectly setting the FK in the Card Table
        //but because we are playing with entity so we will have to set as per the entity
        cardRepository.save(libraryCard);
        return "The card and the student has been associated";

    }
}
