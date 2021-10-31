package dk.kea.paintings.controllers;

import dk.kea.paintings.models.Artist;
import dk.kea.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Julius Panduro
 */
@RestController
public class Artists {

    @Autowired
    ArtistRepository artists;

    //Getting all Artists
    @GetMapping("/artists")
    public List<Artist> getArtists() {
        return artists.findAll();
    }

    //Getting a artist by id
    @GetMapping("/artists/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artists.findById(id).orElseThrow(()-> new ResourceNotFoundException("Artist does not exist"));
    }

    //Add's an artist using post
    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist newArtist) {
        newArtist.setId(null);
        return artists.save(newArtist);
    }

    @PostMapping("/artists/gallery/{artistId}/{galleryId}")
    public Artist addGalleryToArtist(@PathVariable Long galleryId, @PathVariable Long artistId){
        Artist foundArtist = artists.getById(artistId);
        System.out.println(artistId);
        System.out.println(galleryId);
        return null;
    }


    //Updates a artists by id
    @PutMapping("/artists/{id}")
    public String updateArtistById(@PathVariable long id, @RequestBody Artist artistToUpdateWith) {
        if (artists.existsById(id)) {
            artistToUpdateWith.setId(id);
            artists.save(artistToUpdateWith);
            return "Gallery is now Updated";
        } else return "Gallery id is not found";
    }


    @PatchMapping("/artists/{id}")
    public String updateArtistById(@PathVariable Long id, @RequestBody Artist newArtist) {
        return artists.findById(id).map(foundArtist -> {
            if (newArtist.getName() != null) foundArtist.setName(newArtist.getName());
            if (newArtist.getAge() != 0) foundArtist.setAge(newArtist.getAge());
            if (newArtist.getBirthDate() != null) foundArtist.setBirthDate(newArtist.getBirthDate());
            if (newArtist.getGender() != null) foundArtist.setGender(newArtist.getGender());
            if (newArtist.getNationality() != null) foundArtist.setNationality(newArtist.getNationality());
            if (newArtist.getPrimaryStyle() != null) foundArtist.setPrimaryStyle(newArtist.getPrimaryStyle());
            artists.save(foundArtist);
            return "Artist updated";
        }).orElse("Artist not found");
    }


    //Delete an artists by id.
    @DeleteMapping("/artists/{id}")
    public void deleteArtistById(@PathVariable long id) {
        artists.deleteById(id);
    }

}
