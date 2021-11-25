package com.dh.aula30hql.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Equipe {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cidade;
    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private Set<Jogador> jogadores = new HashSet<>();

    public Equipe() {
    }

    public Equipe(String nome, String cidade, Set<Jogador> jogadores) {
        this.nome = nome;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }


}
