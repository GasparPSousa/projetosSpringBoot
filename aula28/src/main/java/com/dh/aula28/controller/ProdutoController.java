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

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        produtoService.guardar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProduto() {
        return ResponseEntity.ok(produtoService.obterTodos());
    }
}
