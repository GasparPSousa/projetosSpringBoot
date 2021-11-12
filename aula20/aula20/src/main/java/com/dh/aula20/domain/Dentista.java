package com.dh.aula20.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentista {

    private String nome;
    private String sobrenome;
    private String matricula;
    private String email;
    private Integer idade;

    public Dentista(String nome, String sobrenome, String matricula, String email, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.email = email;
        this.idade = idade;
    }
}
