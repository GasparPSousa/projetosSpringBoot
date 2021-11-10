package br.com.dh.integra.odonto.controller;

import br.com.dh.integra.odonto.domain.Paciente;
import br.com.dh.integra.odonto.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteControllerLista {

    private final IPacienteService pacienteService;

    @Autowired
    public PacienteControllerLista(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listarpaciente")
    public List<Paciente> getPaciente() {
        return pacienteService.listPaciente();
    }


}
