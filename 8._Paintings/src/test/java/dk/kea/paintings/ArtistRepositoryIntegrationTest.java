package dk.kea.paintings;

import dk.kea.paintings.models.Artist;
import dk.kea.paintings.repositories.ArtistRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Julius Panduro
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ArtistRepository artists;

    @Test
    public void whenFindByNameThenReturnArtist(){
      //given
        Artist artist = new Artist();
        artist.setName("Svend Erik");
        testEntityManager.persist(artist);
        // all the givens above executes first when using .flush()
        testEntityManager.flush();


        //when
        Artist artistFound = artists.findByName("Svend Erik");

        //then
      //  assertEquals(artistFound.equals(artist));

    }


}
