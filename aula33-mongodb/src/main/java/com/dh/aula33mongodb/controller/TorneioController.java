package com.dh.aula33mongodb.controller;

import com.dh.aula33mongodb.model.Torneio;
import com.dh.aula33mongodb.service.TorneioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    private TorneioService torneioService;

    @Autowired
    public TorneioController(TorneioService torneioService) {
        this.torneioService = torneioService;
    }

    @PostMapping
    public Torneio adicionarTorneio(@RequestBody Torneio torneio) {
        return torneioService.guardarTorneio(torneio);
    }

    @GetMapping
    public List<Torneio> listarTorneio() {
        return torneioService.listarTorneios();
    }
}
