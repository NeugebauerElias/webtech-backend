/*package de.htw.webtech;

import de.htw.webtech.web.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardRestController.class)
public class AlbumRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumService service;

    @Test
    public void testGetAlbum() throws Exception {
        // Test data and service moc
        Card c1 = new Card("flasche", "bottle");
        Card c2 = new Card("Dino", "Trex");
        Album a1 = new Album("album");
        a1.setId(1L);
        c1.setId(24L);
        c1.setAlbum(a1);
        c2.setId(25L);
        c2.setAlbum(a1);
        when(service.get(1L)).thenReturn(a1);

        // Expected Result
        String expected = "{\"id\":24,\"frontInformation\":\"flasche\",\"backInformation\":\"bottle\"}" +
                "{\"id\":25,\"frontInformation\":\"Dino\",\"backInformation\":\"Trex\"}";

        // Call and comparison
        this.mockMvc.perform(get("/album/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));

    }
}
*/
