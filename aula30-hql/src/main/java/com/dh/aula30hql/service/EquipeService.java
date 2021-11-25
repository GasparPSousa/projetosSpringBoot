package com.dh.aula30hql.service;

import com.dh.aula30hql.entities.Equipe;
import com.dh.aula30hql.repository.IEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

    @Autowired
    private IEquipeRepository repository;

    // Inserir
    public void insert(Equipe equipe) {
        repository.save(equipe);
    }
}
