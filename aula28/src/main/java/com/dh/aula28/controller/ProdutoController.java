package com.dh.aula28.controller;

import com.dh.aula28.model.Produto;
import com.dh.aula28.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final IProdutoService produtoService;

    @Autowired
    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Criar novo produto
    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        produtoService.guardar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Listar Todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto() {
        return ResponseEntity.ok(produtoService.obterTodos());
    }

    // Buscar produto por id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        Produto produto = produtoService.buscar(id).orElse(null);
        return ResponseEntity.ok(produto);
    }

    // Excluir produto por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Atualizar produto
    public ResponseEntity<?> atualizar(@RequestBody Produto produto) {
        produtoService.atualizar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
