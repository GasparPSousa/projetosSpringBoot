package com.dh.aula34mongoDB.controllers;

import com.dh.aula34mongoDB.exceptions.BadRequestException;
import com.dh.aula34mongoDB.model.Estado;
import com.dh.aula34mongoDB.model.Pacote;
import com.dh.aula34mongoDB.repositories.PacoteRepository;
import com.dh.aula34mongoDB.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private PacoteService pacoteService;

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }


    @PostMapping
    public Pacote registrar(@RequestBody Pacote pacote) throws BadRequestException {


        if(pacoteRepository.findByCodigo(pacote.getCodigo()).isEmpty()) {
            return pacoteService.adicionar(pacote);
        } else {
            throw new BadRequestException("Já existe pacote com esse código");
        }

    }

    @GetMapping
    public List<Pacote> listar() {
        return pacoteService.listar();
    }

    @GetMapping("/acaminho")
    public List<Pacote> aCaminho() {
        return pacoteService.pacoteACaminho();
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processarErrorBadRequest(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @GetMapping("/{estado}")
    public List<Pacote> buscarPacotes(@PathVariable("estado") String estado) {
        Estado convertEstadoParaNum = Estado.valueOf(estado.toUpperCase());
        return pacoteService.buscarPacotes(convertEstadoParaNum);
     }

//    @GetMapping("/acaminho")
//    public List<Pacote> buscarPacotes() {
//
//        return pacoteService.buscarPacotes(Estado.A_CAMINHO);
//    }

}
