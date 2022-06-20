/*package de.htw.webtech;

import de.htw.webtech.web.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


public class AlbumServiceTest {

        @Autowired
        AlbumService service;

        @MockBean
        AlbumRepository repository;

    @Test
    @DisplayName("should get all cards from an album")
    void testGetAlbum(){
        var c1 = new Card("flasche", "bottle");
        var c2 = new Card("Dino", "Trex");
        Album a1 = new Album("album");
        a1.setId(1L);
        c1.setId(24L);
        c1.setAlbum(a1);
//        c2.setId(25L);
//        c2.setAlbum(a1);

        doReturn(Optional.of(c1)).when(repository).findById(1L);

        // Expected Result
        Set<Card> expected = new HashSet<>();
        expected.add(c1);
//        expected.add(c2);

        Album actual = service.get(1L);

        assertEquals(actual.getCards(), expected);
    }

}
*/
