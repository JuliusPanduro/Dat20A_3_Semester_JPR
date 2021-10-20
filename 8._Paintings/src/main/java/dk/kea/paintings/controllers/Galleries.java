package dk.kea.paintings.controllers;

import dk.kea.paintings.exceptions.ResourceNotFoundException;
import dk.kea.paintings.models.Gallery;
import dk.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Julius Panduro
 */
@RestController
public class Galleries {

    @Autowired
    GalleryRepository galleries;


    @GetMapping("/galleries")
    public List<Gallery> getGalleries() {
        return galleries.findAll();
    }

    @GetMapping("/galleries/{id}")
    public Gallery getGalleryById(@PathVariable long id) {
        return galleries.findById(id).orElseThrow(()-> new ResourceNotFoundException("Gallery does not exist"));
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery newGallery) {
        newGallery.setGalleryID(null);
        return galleries.save(newGallery);
    }

    @PutMapping("/galleries/{id}")
    public String updateGalleryById(@PathVariable long id, @RequestBody Gallery galleryToUpdateWith) {
        if (galleries.existsById(id)) {
            galleryToUpdateWith.setGalleryID(id);
            galleries.save(galleryToUpdateWith);
            return "Gallery is now Updated";
        } else
            return "Gallery id is not found";
    }


    @PatchMapping("/galleries/{id}")
    public String patchGalleryById(@PathVariable Long id, @RequestBody Gallery patchedGallery) {
        return galleries.findById(id).map(foundGallery -> {
            if (patchedGallery.getName() != null) {
                foundGallery.setName(patchedGallery.getName());
            }
            if (patchedGallery.getOwner() != null) {
                foundGallery.setOwner(patchedGallery.getOwner());
            }
            if (patchedGallery.getSquareFeet() != 0) {
                foundGallery.setSquareFeet(patchedGallery.getSquareFeet());
            }
            if (patchedGallery.getLocation() != null) {
                foundGallery.setLocation(patchedGallery.getLocation());
            }
            galleries.save(foundGallery);
            return "Gallery Patched";
        }).orElse("Gallery Not found");
    }


    @DeleteMapping("/galleries/{id}")
    public void deleteGalleryById(@PathVariable long id) {
        galleries.deleteById(id);
    }
}
