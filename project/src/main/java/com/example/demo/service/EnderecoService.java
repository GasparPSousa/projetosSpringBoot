package com.example.demo.service;

import com.example.demo.model.Endereco;
import com.example.demo.repository.IDao;

import java.util.List;
import java.util.Optional;

public class EnderecoService {

    private IDao<Endereco> enderecoDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco) {
        enderecoDao.salvar(endereco);
        return endereco;
    }

    public Optional<Endereco> buscar(Integer id) {
        return enderecoDao.buscar(id);
    }

    public List<Endereco> buscarTodos() {
        return enderecoDao.buscarTodos();
    }

    public void excluir(Integer id) {
        enderecoDao.excluir(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return enderecoDao.atualizar(endereco);
    }
}
