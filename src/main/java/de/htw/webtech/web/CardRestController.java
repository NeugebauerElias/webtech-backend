package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardRestController {

    private List<Card> cardList;
    @Autowired
    public CardService cardService;

    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public ModelAndView showHomeScreen() {
        return new ModelAndView("home");
    }

    @PostMapping("/card")
    public Card createCard(@RequestBody Card card){
        return cardService.save(card);
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable String id){
        Long cardId = Long.parseLong(id);
        return cardService.get(cardId);
    }

    @GetMapping("/cards")
    public ResponseEntity<List<Card>>getAllCards(){
        return ResponseEntity.ok(cardService.findAll());
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCard(@PathVariable("id") Long id) {
        cardService.deleteCard(id);
    }

    @PutMapping("/cards/{id}")
    public void updateCard(@PathVariable("id") Long id, @RequestBody Card card) {
        cardService.updateCard(id, card);
    }

}
