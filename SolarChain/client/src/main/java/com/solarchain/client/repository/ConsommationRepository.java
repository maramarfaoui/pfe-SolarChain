package com.solarchain.client.repository;

import com.solarchain.client.entity.Client;
import com.solarchain.client.entity.Consommation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsommationRepository extends MongoRepository<Consommation, String> {
}
