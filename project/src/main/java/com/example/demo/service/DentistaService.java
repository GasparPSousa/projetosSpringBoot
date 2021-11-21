package com.example.demo.service;

import com.example.demo.model.Dentista;
import com.example.demo.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    private IDao<Dentista> dentistaDao;

    public DentistaService(IDao<Dentista> dentistaDao) {

        this.dentistaDao = dentistaDao;
    }

    public Dentista registrarDentista(Dentista dentista) {
        return dentistaDao.salvar(dentista);

    }

    public void excluir(Integer id) {

        dentistaDao.excluir(id);
    }

    public Optional<Dentista> buscar(Integer id) {

        return dentistaDao.buscar(id);
    }

    public List<Dentista> buscarTodos() {

        return dentistaDao.buscarTodos();
    }

    public Dentista atualizar(Dentista dentista) {

        return dentistaDao.atualizar(dentista);
    }
}
