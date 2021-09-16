package com.example.trash_api.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Julius Panduro
 */
@RestController
public class SupermarioController {

    List<String> marioChars = Arrays.asList("Mario","Luigi","Toad","Peach","Bowser","Yoshi","Wario");
    Random random = new Random();


    @GetMapping("/supermario/characters")
    public String superMarioChars(){
        return marioChars.get(random.nextInt(marioChars.size()));
    }

}
