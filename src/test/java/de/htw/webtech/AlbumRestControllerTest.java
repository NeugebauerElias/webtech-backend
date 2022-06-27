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
    private CardRestController cardRestController;

    @MockBean
    private AlbumService service;

    @Test
    public void testGetRoute() throws Exception {
        // Test data and service moc
        Album a1 = new Album("Music");
        a1.setId(11L);
        a1.setCards(null);
        when(service.get(11L)).thenReturn(a1);

        // Expected Result
        String expected = """
                {
                    "albumId": 9,
                    "name": "Music",
                    "cards": null
                }""";

        // Call and comparison
        this.mockMvc.perform(get("/album/11"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));

    }
}*/

