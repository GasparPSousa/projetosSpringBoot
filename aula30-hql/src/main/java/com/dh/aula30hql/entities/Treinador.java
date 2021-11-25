package com.dh.aula30hql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Treinador {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "treinador", fetch = FetchType.LAZY)
    private Set<Jogador> jogadores = new HashSet<>();

    public Treinador() {
    }

    public Treinador(String nome, Set<Jogador> jogadores) {
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }


}
