package com.dh.aula33mongodb.repository;

import com.dh.aula33mongodb.model.Torneio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends MongoRepository<Torneio, String> {
}
