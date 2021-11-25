package com.dh.aula30hql.repository;

import com.dh.aula30hql.entities.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITreinadorRepository extends JpaRepository<Treinador, Integer> {
}
