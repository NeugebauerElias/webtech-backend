package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
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

    @Autowired
    public CardRepository cardRepository;

    @Autowired
    public AlbumRepository albumRepository;

    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/album/{albumId}/card")
    public ResponseEntity<Card> createCard(@PathVariable(value = "albumId") Long albumId,@RequestBody Card cardRequest){
        Card card = albumRepository.findById(albumId).map(album -> {
            cardRequest.setAlbum(album);
            return cardService.save(cardRequest);
        }).orElseThrow(()-> new RuntimeException("Not found Album with id: " + albumId));
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }


    @GetMapping("/cards/{id}")
    @ResponseBody
    public Card getCard(@PathVariable String id){
        Long cardId = Long.parseLong(id);
        return cardService.get(cardId);
    }


    @DeleteMapping("/cards/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable("id") Long id) {
        return cardRepository.findById(id).map(card -> {
            cardRepository.delete(card);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException("AlbumId " + id + " not found"));
    }

    @PutMapping("/cards/{id}")
    public void updateCard(@PathVariable("id") Long id, @RequestBody Card card) {
        cardService.updateCard(id, card);
    }

}
