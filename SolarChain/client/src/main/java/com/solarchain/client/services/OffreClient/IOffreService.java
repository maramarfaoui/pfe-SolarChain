package com.solarchain.client.services.OffreClient;

import com.solarchain.client.entity.Client;
import com.solarchain.client.entity.OffreClient;

public interface IOffreService {

    OffreClient addOffre(OffreClient c);
    void approveOffre(String offreId);
    OffreClient findById(String id);
}
