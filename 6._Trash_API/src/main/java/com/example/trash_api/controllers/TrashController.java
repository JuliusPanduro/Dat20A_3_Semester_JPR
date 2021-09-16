package com.example.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Julius Panduro
 */
@RestController
public class TrashController {

    List<String> sins = Arrays.asList("Lust", "Gluttony", "Greed", "Sloth", "Wrath", "Envy", "Pride");


    @GetMapping("/root")
    public String route() {
        return "Hello World";
    }

    @GetMapping("/clock")
    public Date dateRoute() {
        return new Date();
    }

    @GetMapping("/sevensins")
    public String getSin() {
        int number = 4;
        return sins.get(number);
    }

}
