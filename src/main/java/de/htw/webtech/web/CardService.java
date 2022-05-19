package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    CardRepository repo;

    public Card save(Card card) {
        return repo.save(card);
    }

    public Card get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void deleteCard(Long id) {
        boolean exists = repo.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "card with id " + id + " does not exist"
            );
        }
        repo.deleteById(id);
    }
}
