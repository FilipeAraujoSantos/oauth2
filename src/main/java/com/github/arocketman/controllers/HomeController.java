package com.github.arocketman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String index(){
        return "Olá Cabeça!";
    }

    @GetMapping(value = "/private")
    public String privateArea(){
        return "Private area";
    }

}
