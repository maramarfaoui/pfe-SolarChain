package com.solarchain.client.services.Projet;

import com.solarchain.client.entity.OffreClient;
import com.solarchain.client.entity.Projet;
import com.solarchain.client.repository.OffreClientRepository;
import com.solarchain.client.repository.ProjetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProjetServiceImpl implements IProjetService{
    @Autowired
    OffreClientRepository offreClientRepository;
    ProjetRepository projetRepository;




    public boolean addProjetIfOffreValide(String offreId, Projet projet) {
        OffreClient offre = offreClientRepository.findById(offreId).orElse(null);
        if (offre != null && offre.isValide()) {
            projetRepository.save(projet);
            return true;
        }
        return false;
    }
}
