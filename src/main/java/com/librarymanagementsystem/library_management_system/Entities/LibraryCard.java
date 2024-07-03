package com.librarymanagementsystem.library_management_system.Entities;

import com.librarymanagementsystem.library_management_system.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "card_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(value = EnumType.STRING) // Enum items will be treated as a String
    private CardStatus cardStatus;

    private int noOfBooksIssued;

    private Date validity;

    @JoinColumn //The new column is adding in the Library Card
    @OneToOne // Which is mapping ? here is one to one relation
    private Student student; // Tells on which entity/Table we are joining

}
