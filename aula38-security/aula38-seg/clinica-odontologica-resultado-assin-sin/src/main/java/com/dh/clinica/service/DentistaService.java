package com.dh.clinica.service;

import com.dh.clinica.model.Dentista;
import com.dh.clinica.repository.impl.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class DentistaService {

    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaService(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    public Dentista registrarDentista(Dentista dentista) {
        return dentistaRepository.save(dentista);

    }

    public void apagar(Integer id) {
        dentistaRepository.deleteById(id);
    }

    public Optional<Dentista> buscar(Integer id) {
        return dentistaRepository.findById(id);
    }

    public List<Dentista> buscarTodos() {
        return dentistaRepository.findAll();
    }

    public Dentista apagar(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }
}
