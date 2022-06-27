package de.htw.webtech;

import de.htw.webtech.web.Album;
import de.htw.webtech.web.AlbumRepository;
import de.htw.webtech.web.AlbumService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class AlbumServiceTest {

    @Autowired
    private AlbumService service;

    @MockBean
    private AlbumRepository repository;

    @Test
    @DisplayName("Should find album by Id")
    void testGet() {
        var a1 = new Album("Musik");
        doReturn(Optional.of(a1)).when(repository).findById(3L);

        Album actual = service.get(3L);
        assertEquals(actual.getName(), "Musik");

    }
}
