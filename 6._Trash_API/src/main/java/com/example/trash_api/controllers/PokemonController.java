package com.example.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Julius Panduro
 */
@RestController
public class PokemonController {
    private List<String> pokemonList = Arrays.asList("Bulbasaur", "Squirtle", "Umbreon");

    @GetMapping("/pokemon")
    public List pokemonList() {
        return pokemonList;

    }

    @GetMapping("/pokemon/go")
    public boolean isGo(){
        return true;
    }

}
