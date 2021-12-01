package com.dh.aula34mongoDB.controllers;

import com.dh.aula34mongoDB.model.Estado;
import com.dh.aula34mongoDB.model.Pacote;
import com.dh.aula34mongoDB.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{estado}")
    public List<Pacote> buscarPacotes(@PathVariable("estado") String estado) {
        Estado convertEstadoParaNum = Estado.valueOf(estado.toUpperCase());
        return pacoteService.buscarPacotes(convertEstadoParaNum);
     }

    @GetMapping("/acaminho")
    public List<Pacote> buscarPacotes() {
        return pacoteService.buscarPacotes(Estado.A_CAMINHO);
    }

}
