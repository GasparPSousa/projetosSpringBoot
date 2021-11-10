package br.com.dh.integra.odonto.controller;

// Para o email

import br.com.dh.integra.odonto.domain.Paciente;
import br.com.dh.integra.odonto.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscaremail")
    public String busca(Model model) {
        Paciente paciente = pacienteService.buscaPorEmail(
                "fernando.inter@internacional.com"
        );

        model.addAttribute("nome", paciente.getNome());
//        model.addAttribute("sobrenome", paciente.getSobrenome());

        return  "index";
    }
}
