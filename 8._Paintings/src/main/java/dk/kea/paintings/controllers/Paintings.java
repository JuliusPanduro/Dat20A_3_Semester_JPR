package dk.kea.paintings.controllers;

import dk.kea.paintings.exceptions.ResourceNotFoundException;
import dk.kea.paintings.models.Painting;
import dk.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Julius Panduro
 */
@Api(value = "Painting Controller", description = "REST endpoints for paintings")
@RestController
public class Paintings {
    @Autowired
    PaintingRepository paintings;

    //Getting all Paintings
    @GetMapping("/paintings")
    public List<Painting> getPaintings() {
        return paintings.findAll();
    }

    //Getting a single painting by using a id.
    @GetMapping("/paintings/{id}")
    public Painting getPaintingById(@PathVariable long id) {
        return paintings.findById(id).orElseThrow(() -> (new ResourceNotFoundException("Painting does not exist")));
    }


    @GetMapping("/paintings/timeline")
    public List<Painting> getPaintingByArtistAndYear(@RequestParam String artist, @RequestParam int year) {
        return paintings.findPaintingsByArtistAndYear(artist, year);
    }


    @GetMapping("/paintings/pricelookup/{price}")
    public List<Painting> getPaintingAboveACertainPrice(@PathVariable double price) {
        System.out.println(price);
        return paintings.findPaintingsAboveCertainPrice(price);
    }


    //Posting a painting to the arraylist.
    @PostMapping("/paintings")
    public Painting addPaintings(@RequestBody Painting newPainting) {
        return paintings.save(newPainting);

    }

    //Updates a painting by using id
    @PutMapping("/paintings/{id}")
    public String updatePaintingById(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith) {
        if (paintings.existsById(id)) {
            paintingToUpdateWith.setId(id);
            paintings.save(paintingToUpdateWith);
            return "Painting is now Updated";
        } else
            return "Painting id is not found";
    }

    @PatchMapping("/paintings/{id}")
    public String patchPaintingById(@PathVariable Long id, @RequestBody Painting patchedPainting) {
        return paintings.findById(id).map(foundPainting -> {
            if (patchedPainting.getArtist() != null) foundPainting.setArtist(patchedPainting.getArtist());
            if (patchedPainting.getYear() != 0) foundPainting.setYear(patchedPainting.getYear());
            if (patchedPainting.getGenre() != null) foundPainting.setGenre(patchedPainting.getGenre());
            if (patchedPainting.getPrice() != 0) foundPainting.setPrice(patchedPainting.getPrice());
            if (patchedPainting.getTitle() != null) foundPainting.setTitle(patchedPainting.getTitle());
            paintings.save(foundPainting);
            return "Painting updated";
        }).orElse("Painting not found");
    }

   /* //Patches a Painting by using id
    @PatchMapping("/paintings/{id}")
    public Painting patchPainting(@PathVariable Long id, @RequestBody String body) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Painting newPainting = objectMapper.readValue(body, Painting.class);
            paintingsList.set(id, newPainting);
            return newPainting;
        } catch (JsonProcessingException error) {
            System.out.println(error);
            Painting unknownPainting = new Painting();
            paintingsList.set(id, unknownPainting);
            return unknownPainting;
        }
    }

    */

    //Delete a paiting by using id
    @DeleteMapping("/paintings/{id}")
    public void deletePaintingById(@PathVariable Long id) {
        paintings.deleteById(id);
    }

}
