package com.aula29.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String curso;
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    private Set<Aluno> alunos = new HashSet<>();
    // Um professor pode ter muitos alunos

    public Professor() {
    }

    public Professor(String nome, String curso, Set<Aluno> alunos) {
        this.nome = nome;
        this.curso = curso;
        this.alunos = alunos;
    }

    public Professor(Long id, String nome, String curso, Set<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.alunos = alunos;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
}
