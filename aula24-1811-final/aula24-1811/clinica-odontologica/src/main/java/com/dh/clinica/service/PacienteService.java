package com.dh.clinica.service;


import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Paciente;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente p) {
        p.setDataCadastro(new Date());
        return pacienteIDao.salvar(p);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }

    public void excluir(Integer id) {
        pacienteIDao.excluir(id);
    }

    public Paciente atualizar(Paciente p) {
        return pacienteIDao.atualizar(p);
    }
}
