package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardRestController {

    @Autowired
    CardService service;

    @PostMapping("/things")
    public Card createCard(@RequestBody Card card){
        return service.save(card);
    }

    @GetMapping("/things/{id}")
    public Card getCard(@PathVariable String id){
        Long cardId = Long.parseLong(id);
        return service.get(cardId);
    }
}
