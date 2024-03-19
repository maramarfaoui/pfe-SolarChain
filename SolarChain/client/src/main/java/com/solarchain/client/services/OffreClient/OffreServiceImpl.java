package com.solarchain.client.services.OffreClient;

import com.solarchain.client.entity.Client;
import com.solarchain.client.entity.OffreClient;
import com.solarchain.client.repository.ClientRepository;
import com.solarchain.client.repository.OffreClientRepository;
import com.solarchain.client.services.IClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OffreServiceImpl implements IOffreService {

    @Autowired
    OffreClientRepository offreClientRepository ;

    @Override
    public OffreClient addOffre(OffreClient c) {
        log.info("inserting start");
        OffreClient offreClient =  offreClientRepository.insert(c);
        log.info("success" + offreClient);
        return offreClient;

    }

    @Override
    public OffreClient findById(String id) {
        return offreClientRepository.findById(id).orElse(null);
    }

    @Override
    public void approveOffre(String offreId) {
        OffreClient offreClient = findById(offreId);
        if (offreClient != null) {
            offreClient.setValide(true);
            offreClientRepository.save(offreClient);
        }
    }
}
