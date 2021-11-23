package com.dh.aula28.service;

import com.dh.aula28.dao.IProdutoRepository;
import com.dh.aula28.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements IProdutoService{

    private final IProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public void guardar(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Optional<Produto>  atualizar(Produto produto) {
        produtoRepository.save(produto);
        return produtoRepository.findById(produto.getId());
    }

    @Override
    public Optional<Produto> buscar(Long id) {
        return produtoRepository.findById(id);
    }
}
