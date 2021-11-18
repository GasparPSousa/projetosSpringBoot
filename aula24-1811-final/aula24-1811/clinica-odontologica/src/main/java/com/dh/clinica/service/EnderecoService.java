package com.dh.clinica.service;


import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Endereco;


import java.util.List;
import java.util.Optional;

public class EnderecoService {
    private IDao<Endereco> enderecoDao;

    public EnderecoService(IDao<Endereco> enderecoDao) {
        this.enderecoDao = enderecoDao;
    }
    public Endereco guardar(Endereco d){
        enderecoDao.salvar(d);
        return d;
    }
    public Optional<Endereco> buscar(Integer id){
        return enderecoDao.buscar(id);
    }
    public List<Endereco> buscarTodos(){
        return enderecoDao.buscarTodos();
    }
    public void eliminar(Integer id){
        enderecoDao.excluir(id);
    }

}
