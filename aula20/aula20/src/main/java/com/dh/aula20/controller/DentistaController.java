package com.dh.aula20.controller;

import com.dh.aula20.domain.Dentista;
import com.dh.aula20.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DentistaController {

    @Autowired
    public DentistaService dentistaService;

    @GetMapping("/dentista/listar")
    public Map<Integer, Dentista> listarDentistas() {
        return dentistaService.buscarDentista();
    }

    @GetMapping("/dentista/criar")
    public Dentista criarDentista() {
        return dentistaService.criarDentista();
    }

    @GetMapping("/dentista/deletar/{id}")
    public String deletarDentistas(@PathVariable Integer id) {
        dentistaService.deletar(id);
        return "Dentista Deletado";
    }
}
