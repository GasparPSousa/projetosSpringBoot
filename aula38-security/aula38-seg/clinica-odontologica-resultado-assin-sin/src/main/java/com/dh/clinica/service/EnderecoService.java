package com.dh.clinica.service;


import com.dh.clinica.model.Endereco;
import com.dh.clinica.repository.impl.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco guardar(Endereco d){
        enderecoRepository.save(d);
        return d;
    }
    public Optional<Endereco> buscar(Integer id){
        return Optional.of(enderecoRepository.getOne(Long.valueOf(id)));
    }
    public List<Endereco> buscarTodos(){
        return enderecoRepository.findAll();
    }
    public void apagar(Integer id){
        enderecoRepository.deleteById(Long.valueOf(id));
    }

}
