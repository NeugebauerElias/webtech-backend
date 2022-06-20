package de.htw.webtech;

import de.htw.webtech.web.Album;
import de.htw.webtech.web.Card;
import de.htw.webtech.web.CardRepository;
import de.htw.webtech.web.CardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CardServiceTest {

    @Autowired
    CardService service;

    @MockBean
    CardRepository repository;

    @Test
    @DisplayName("should find a card by ts id")
    void testGetCard(){
        var c1 = new Card("Löwe", "Lion");
        doReturn(Optional.of(c1)).when(repository).findById(3L);

        Card actual = service.get(3L);
        assertEquals(actual.getBackInformation(), "Lion");
    }
}

