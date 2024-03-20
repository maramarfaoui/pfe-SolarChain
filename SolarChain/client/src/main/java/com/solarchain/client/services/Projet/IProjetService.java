package com.solarchain.client.services.Projet;

import com.solarchain.client.entity.Projet;

public interface IProjetService {

    boolean addProjetIfOffreValide(String offreId, Projet projet);
    Projet getProjetById(String projetId);
    Projet assignFondToProjet(String projetId, Float montant);
    float calculatePercentage(String projetId);
}
