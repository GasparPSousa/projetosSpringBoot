package com.dh.aula20.controller;

import com.dh.aula20.domain.Paciente;
import com.dh.aula20.service.OdontoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OdontoController {

    private OdontoService service;

    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes() {
        return service.buscarPaciente();
    }

    @GetMapping("criar")
    public Paciente criarPaciente(){
        return service.criarPaciente();
    }

    @GetMapping("deletar/{id}")
    public String deletarPacientes(@PathVariable Integer id){
        service.deletar(id);
        return "Paciente Deletado";
    }

}
