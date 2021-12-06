package com.dh.aula34mongoDB.repositories;

import com.dh.aula34mongoDB.model.Estado;
import com.dh.aula34mongoDB.model.Pacote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacoteRepository extends MongoRepository<Pacote, String> {

    @Query
    public List<Pacote> findByEstado(Estado estado);

    @Query
    public List<Pacote> findByCodigo(String string);
}
