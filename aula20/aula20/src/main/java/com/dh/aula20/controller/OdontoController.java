package com.dh.aula20.controller;

import com.dh.aula20.domain.Dentista;
import com.dh.aula20.domain.Paciente;
import com.dh.aula20.service.DentistaService;
import com.dh.aula20.service.OdontoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class OdontoController {

    @Autowired
    private OdontoService service;


    @GetMapping("/paciente/listar")
    public Map<Integer, Paciente> listarPacientes() {
        return service.buscarPaciente();
    }

    @GetMapping("/paciente/criar")
    public Paciente criarPaciente(){
        return service.criarPaciente();
    }

    @GetMapping("/paciente/deletar/{id}")
    public String deletarPacientes(@PathVariable Integer id){
        service.deletar(id);
        return "Paciente Deletado";
    }


}
