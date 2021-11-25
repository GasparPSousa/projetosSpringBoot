package com.dh.aula30hql.dao;

public class JogadorDAO {

    private String nome;
    private String numero;
    private String posicao;
    private Integer idTreinador; //FK
    private Integer idEquipe;    //FK

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getIdTreinador() {
        return idTreinador;
    }

    public void setIdTreinador(Integer idTreinador) {
        this.idTreinador = idTreinador;
    }

    public Integer getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
    }
}
