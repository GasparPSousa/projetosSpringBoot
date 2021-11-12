package com.dh.clinica.controller;

import com.dh.clinica.dao.impl.EnderecoDaoH2;
import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PacienteController {

    PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new EnderecoDaoH2()));

    //EXERCICIO 2
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("pacientes", pacienteService.buscarTodos());
        return modelAndView;
    }
    //EXERCICIO 1
    @RequestMapping(value="/adicionar", method= RequestMethod.GET)
    public String adicionar() {
        return"adicionar-data";
    }
    //EXERCICIO 1
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Paciente paciente) {
        pacienteService.salvar(paciente);

        return index();
    }

    //EXERCICIO 3
    @RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
    public ModelAndView delete(@PathVariable Integer id) {
        pacienteService.remover(id);
        return index();
    }
    //EXERCICIO 3
    @RequestMapping(value="/edit/{id}", method= RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id) {
        Optional<Paciente> paciente = pacienteService.buscar(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-data");
        modelAndView.addObject("paciente", paciente.get());
        return modelAndView;
    }
    //EXERCICIO 3
    @RequestMapping(value="/editar", method= RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Paciente paciente) {
        pacienteService.atualizar(paciente);
        return index();
    }
}
