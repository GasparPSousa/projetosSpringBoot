package com.dh.aula28.service;

import com.dh.aula28.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProdutoService {

    // Obter todos
    List<Produto> obterTodos();

    // Salvar
    void guardar(Produto produto);

    // Excluir
    void excluir(Long id);

    // Atualizar
    public Optional<Produto> atualizar(Produto produto);

    // Buscar por id
    public Optional<Produto> buscar(Long id);


}
