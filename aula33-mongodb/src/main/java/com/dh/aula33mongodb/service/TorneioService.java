package com.dh.aula33mongodb.service;

import com.dh.aula33mongodb.model.Torneio;
import com.dh.aula33mongodb.repository.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneioService {

    private TorneioRepository torneioRepository;

    @Autowired
    public TorneioService(TorneioRepository torneioRepository) {
        this.torneioRepository = torneioRepository;
    }

    public Torneio guardarTorneio(Torneio torneio) {
        return torneioRepository.save(torneio);
    }

    public List<Torneio> listarTorneios() {
        return torneioRepository.findAll();
    }
}
