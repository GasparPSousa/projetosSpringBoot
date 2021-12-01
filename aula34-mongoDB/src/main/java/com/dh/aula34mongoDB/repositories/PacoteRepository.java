package com.dh.aula34mongoDB.repositories;

import com.dh.aula34mongoDB.model.Pacote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends MongoRepository<Pacote, String> {
}
