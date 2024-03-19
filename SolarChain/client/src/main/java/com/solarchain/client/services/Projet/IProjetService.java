package com.solarchain.client.services.Projet;

import com.solarchain.client.entity.Projet;

public interface IProjetService {

    boolean addProjetIfOffreValide(String offreId, Projet projet);
}
