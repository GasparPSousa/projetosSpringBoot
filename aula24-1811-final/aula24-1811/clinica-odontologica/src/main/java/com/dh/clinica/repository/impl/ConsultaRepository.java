package com.dh.clinica.repository.impl;

import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Consulta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsultaRepository implements IDao<Consulta> {

    private List<Consulta> consultas;

    public ConsultaRepository() {
        consultas = new ArrayList<>();
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        consultas.add(consulta);
        return consulta;
    }

    @Override
    public Optional<Consulta> buscar(Integer id) {
        return consultas.stream().filter(consulta -> consulta.getId().equals(id)).findFirst();
    }

    @Override
    public void excluir(Integer id) {
        consultas.removeIf(consulta -> consulta.getId().equals(id));
    }

    @Override
    public List<Consulta> buscarTodos() {
        return consultas;
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        excluir(consulta.getId());
        consultas.add(consulta);
        return consulta;
    }
}
