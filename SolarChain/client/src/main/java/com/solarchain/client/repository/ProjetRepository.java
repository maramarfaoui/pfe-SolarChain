package com.solarchain.client.repository;

import com.solarchain.client.entity.Client;
import com.solarchain.client.entity.Projet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjetRepository extends MongoRepository<Projet, String> {
}
