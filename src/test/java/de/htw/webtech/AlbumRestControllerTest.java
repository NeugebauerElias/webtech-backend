package de.htw.webtech;


import de.htw.webtech.web.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;


import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AlbumRestController.class)
@Import(AlbumService.class)
public class AlbumRestControllerTest {

    @MockBean
    AlbumRepository albumRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("should add a new album")
    void testCreateAlbum() {
        Album album = new Album("Web");
        album.setId(1L);
        album.setCards(null);

        Mockito.when(albumRepository.save(album)).thenReturn(album);

        webTestClient.post()
                .uri("/album")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(album))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(albumRepository, times(1)).save(ArgumentMatchers.refEq(album));
    }
}
