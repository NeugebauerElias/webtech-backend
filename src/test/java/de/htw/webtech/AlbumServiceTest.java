/*package de.htw.webtech;

import de.htw.webtech.web.Album;
import de.htw.webtech.web.AlbumRepository;
import de.htw.webtech.web.AlbumService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
@SpringBootTest
public class AlbumServiceTest {

    @InjectMocks
    private AlbumService service;

    @MockBean
    private AlbumRepository repository;

    @Test
    @DisplayName("Should find album by Id")
    void testGet() {
        var a1 = new Album("Musik");
        a1.setId(3L);
        a1.setCards(null);
        doReturn(Optional.of(a1)).when(repository).findById(3L);

        Album actual = service.get(3L);
        assertEquals(actual.getName(), "Musik");

    }

}*/
