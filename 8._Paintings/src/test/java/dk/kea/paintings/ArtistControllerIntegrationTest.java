package dk.kea.paintings;

import dk.kea.paintings.controllers.Artists;
import dk.kea.paintings.models.Artist;
import dk.kea.paintings.repositories.ArtistRepository;
import dk.kea.paintings.repositories.GalleryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

/**
 * @author Julius Panduro
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = Artists.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ArtistControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArtistRepository artists;

    @MockBean
    private GalleryRepository galleries;

    @Test
    public void givenArtistsWhenGetArtistsThenReturnJsonArray() throws Exception {
        Artist artistOne = new Artist();
        Artist artistTwo = new Artist();
        Artist artistThree = new Artist();

        artistOne.setName("Peter");
        artistTwo.setName("Svend");
        artistThree.setName("Erik");

        List<Artist> allArtists = Arrays.asList(artistOne,artistTwo,artistThree);

        given(artists.findAll()).willReturn(allArtists);

        mvc.perform(get("/artists")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",org.hamcrest.Matchers.hasSize(3)))
                .andExpect(jsonPath("$[0].name",is("Peter")))
                .andExpect(jsonPath("$[1].name",is("Svend")))
                .andExpect(jsonPath("$[2].name",is("Erik")));

        verify(artists, VerificationModeFactory.times(1)).findAll();
        reset(artists);

    }


}
