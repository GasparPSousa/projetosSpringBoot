package br.com.dh.aula021.controller;

import br.com.dh.aula021.service.impl.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired                   //Para injetar dependências
    private IPessoaService pessoaService;


    @GetMapping("/{dia}/{mes}/{ano}")   // Para rotear a URL
    public Integer calcularIdade(
            @PathVariable("dia") Integer d,
            @PathVariable("mes") Integer m,
            @PathVariable("ano") Integer a) {

        return  pessoaService.calcularIdade(d, m, a);
    }

}
