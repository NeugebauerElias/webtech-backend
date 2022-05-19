package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private final CardRepository cardRepository;

    public CardService (CardRepository cardRepository)  {
        this.cardRepository = cardRepository;
    }
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Card get(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Card> findAll(){
        List<Card> cards = (List<Card>) cardRepository.findAll();
        return cards.stream().map(card -> new Card(
                card.getBackInformation(),
                card.getFrontInformation()
        )).collect(Collectors.toList());
    }


    public void deleteCard(Long id) {
        boolean exists = cardRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "card with id " + id + " does not exist"
            );
        }
        cardRepository.deleteById(id);
    }
}
