package com.example.demo.controller;


import com.example.demo.model.Endereco;
import com.example.demo.repository.impl.EnderecoDaoH2;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

//    @Autowired
    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoH2());


    @PostMapping
    public ResponseEntity<Endereco> registrarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscar(@PathVariable Integer id) {
        Endereco endereco = enderecoService.buscar(id).orElse(null);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco) {
        ResponseEntity<Endereco> response = null;

        if(endereco.getId() != null && enderecoService.buscar(endereco.getId()).isPresent()){
            response = ResponseEntity.ok(enderecoService.atualizar(endereco));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if(enderecoService.buscar(id).isPresent()) {
            enderecoService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos() {

        return ResponseEntity.ok(enderecoService.buscarTodos());
    }


}
