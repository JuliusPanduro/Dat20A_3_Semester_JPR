package dk.kea.poelse.controllers;

import dk.kea.poelse.models.Poelse;
import dk.kea.poelse.repositories.PoelseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Julius Panduro
 */
@RestController
public class Poelses {

    @Autowired
    PoelseRepository poelses;

    @GetMapping("/poelses")
    public List<Poelse> getPoelses() {
        return poelses.findAll();
    }

    @GetMapping("/poelses/{id}")
    public Poelse getPoelseById(@PathVariable long id) {
        return poelses.findById(id).get();
    }

    @PostMapping("/poelses")
    public Poelse addPoelse(@RequestBody Poelse newPoelse) {
        return poelses.save(newPoelse);
    }


}
