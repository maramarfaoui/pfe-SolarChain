package com.solarchain.client.repository;

import com.solarchain.client.entity.Client;
import com.solarchain.client.entity.Localisation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocalisationRepository extends MongoRepository<Localisation, String> {
}
