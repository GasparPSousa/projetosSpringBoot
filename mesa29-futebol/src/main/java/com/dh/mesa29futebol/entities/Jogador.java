package com.dh.mesa29futebol.entities;

import javax.persistence.*;


@Entity
@Table
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String posicao;
    private int num;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "time_id")
    private Time time;

    public Jogador() {
    }

    public Jogador(String nome, String posicao, int num, Time time) {
        this.nome = nome;
        this.posicao = posicao;
        this.num = num;
        this.time = time;
    }

    public Jogador(Long id, String nome, String posicao, int num, Time time) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.num = num;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
