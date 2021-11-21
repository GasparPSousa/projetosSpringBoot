package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.repository.IDao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteService {

    private IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente salvar(Paciente paciente) {
        paciente.setDataCadastro(new Date());
        return pacienteDao.salvar(paciente);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteDao.buscarTodos();
    }

    public void excluir(Integer id){
        pacienteDao.excluir(id);
    }

    public Paciente atualizar(Paciente paciente) {
        return pacienteDao.atualizar(paciente);
    }
}
