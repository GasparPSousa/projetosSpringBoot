package com.dh.mesa27orm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movimento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private double quantia;

    public Movimento() {
    }

    public Movimento(String descricao, double quantia) {
        this.descricao = descricao;
        this.quantia = quantia;
    }

    public Movimento(Integer id, String descricao, double quantia) {
        this.id = id;
        this.descricao = descricao;
        this.quantia = quantia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantia() {
        return quantia;
    }

    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", quantia=" + quantia +
                '}';
    }
}
