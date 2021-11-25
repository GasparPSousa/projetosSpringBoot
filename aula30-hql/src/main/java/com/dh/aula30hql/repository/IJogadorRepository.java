package com.dh.aula30hql.repository;

import com.dh.aula30hql.entities.Jogador;
import com.dh.aula30hql.entities.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJogadorRepository extends JpaRepository<Jogador, Integer> {

    @Query("select j.nome from Jogador j where j.treinador = ?1")
    List<String> procurarTodosJogadoresPorTreinador(Treinador treinador);

}
