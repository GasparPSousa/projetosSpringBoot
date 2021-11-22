package com.dh.aula27orm.entidade;

import javax.persistence.*;


@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String rg;
    private String nome;
    private String sobrenome;

    public Estudante() {
    }

    public Estudante(String rg, String nome, String sobrenome) {
        this.rg = rg;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Estudante(Integer id, String rg, String nome, String sobrenome) {
        this.id = id;
        this.rg = rg;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + id +
                ", rg='" + rg + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
