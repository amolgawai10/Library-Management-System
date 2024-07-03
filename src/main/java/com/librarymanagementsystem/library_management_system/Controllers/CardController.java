package com.librarymanagementsystem.library_management_system.Controllers;

import com.librarymanagementsystem.library_management_system.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;
    @PostMapping("/generateCard")
    public ResponseEntity addCard(){
        //Print hard copy of card and give it to associated student
        String result = cardService.generateCard();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PutMapping("/associateCardandStudent")
    public ResponseEntity associateCardandStudent(@RequestParam("cardId")Integer cardId,
                                                  @RequestParam("studentId")Integer studentId){
        String result = cardService.associateCardandStudent(cardId,studentId);
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
