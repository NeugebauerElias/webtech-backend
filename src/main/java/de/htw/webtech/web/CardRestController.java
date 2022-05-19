package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardRestController {

    private List<Card> cardList;

    public CardRestController() {
    }

    @Autowired
    CardService service;

    @GetMapping("/")
    public ModelAndView showHelloWorld() {
        return new ModelAndView("home");
    }

    @PostMapping("/cards")
    public Card createCard(@RequestBody Card card){
        return service.save(card);
    }

    @GetMapping("/cards/{id}")
    public Card getCard(@PathVariable String id){
        Long cardId = Long.parseLong(id);
        return service.get(cardId);
    }

    @DeleteMapping(path = "/cards/{id}")
    public void deleteCard(@PathVariable("id") Long id) {
        service.deleteCard(id);
    }

}
