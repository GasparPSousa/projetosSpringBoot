package com.dh.aula34mongoDB.controllers;

import com.dh.aula34mongoDB.model.Pacote;
import com.dh.aula34mongoDB.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private PacoteService pacoteService;

    @Autowired
    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @PostMapping
    public Pacote registrar(@RequestBody Pacote pacote) {
        return pacoteService.adicionar(pacote);
    }
}
