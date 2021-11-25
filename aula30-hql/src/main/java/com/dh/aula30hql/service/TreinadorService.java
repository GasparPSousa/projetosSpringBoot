package com.dh.aula30hql.service;

import com.dh.aula30hql.entities.Treinador;
import com.dh.aula30hql.repository.ITreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorService {

    @Autowired
    private ITreinadorRepository repository;

    public void insert(Treinador treinador) {
        repository.save(treinador);
    }
}
