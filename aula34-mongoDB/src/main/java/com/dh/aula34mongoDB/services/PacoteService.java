package com.dh.aula34mongoDB.services;

import com.dh.aula34mongoDB.model.Estado;
import com.dh.aula34mongoDB.model.Pacote;
import com.dh.aula34mongoDB.repositories.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService {


    private PacoteRepository pacoteRepository;

    @Autowired
    public PacoteService(PacoteRepository pacoteRepository) {
        this.pacoteRepository = pacoteRepository;
    }

    public Pacote adicionar(Pacote pacote) {
       return pacoteRepository.save(pacote);
    }

    public List<Pacote> buscarPacotes(Estado estado) {
        return pacoteRepository.findByEstado(Estado.A_CAMINHO);
    }


}
