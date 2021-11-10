package br.com.dh.integra.odonto.service;

import br.com.dh.integra.odonto.domain.Paciente;

import java.util.List;


public interface IPacienteService {

    List<Paciente> listPaciente();
    Paciente buscaPorEmail(String email);

}
