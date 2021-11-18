package com.dh.clinica.service;

import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Consulta;

import java.util.List;
import java.util.Optional;

public class ConsultaService {

    private IDao<Consulta> turnoRepository;

    public ConsultaService(IDao<Consulta> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Consulta registrarTurno(Consulta consulta){
        return  turnoRepository.salvar(consulta);
    }
    public List<Consulta> listar(){
        return turnoRepository.buscarTodos();
    }
    public void excluir(Integer id){
        turnoRepository.excluir(id);
    }
    public Consulta atualizar(Consulta consulta){
        return turnoRepository.atualizar(consulta);
    }
    public Optional<Consulta> buscar(Integer id){
        return turnoRepository.buscar(id);
    }

}
