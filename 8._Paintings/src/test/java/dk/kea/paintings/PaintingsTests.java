package dk.kea.paintings;


import dk.kea.paintings.services.PaintingsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Julius Panduro
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaintingsTests {


    @Autowired
    PaintingsService service;

    @Test
    public void paintingUnitTest(){

    }


}
