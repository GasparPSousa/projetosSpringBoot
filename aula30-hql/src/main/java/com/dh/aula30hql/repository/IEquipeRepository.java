package com.dh.aula30hql.repository;

import com.dh.aula30hql.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipeRepository extends JpaRepository<Equipe, Integer> {
}
