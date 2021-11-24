package com.aula29.hibernate.model;

import javax.persistence.*;

@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Aluno() {
    }

    public Aluno(String nome, int idade, Professor professor) {
        this.nome = nome;
        this.idade = idade;
        this.professor = professor;
    }

    public Aluno(Long id, String nome, int idade, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.professor = professor;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
