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

    @Override
    public Projet getProjetById(String projetId) {
        return projetRepository.findById(projetId).orElse(null);
    }

    @Override
    public Projet assignFondToProjet(String projetId, Float montant) {

            Projet projet = projetRepository.findById(projetId).orElse(null);

            if (projet != null) {
                if (projet.getNbrJour() == 0) {
                    throw new IllegalArgumentException("Le projet est déjà terminé. Vous ne pouvez pas donner de fonds.");
                }
                Float montantTotalProjet = projet.getMontant();
                Float montantCollecte = projet.getMontantCollecte();

                if (montant <= montantTotalProjet) {
                    montantCollecte += montant;
                    montantTotalProjet -= montant;
                    projet.setMontant(montantTotalProjet);
                    projet.setMontantCollecte(montantCollecte);
                    projetRepository.save(projet);
                } else {
                    throw new IllegalArgumentException("Le montant des fonds donnés dépasse le montant total du projet.");
                }
            } else {
                throw new IllegalArgumentException("Projet non trouvé.");
            }

            return projet;
        }
        @Override
    public float calculatePercentage(String projetId) {
        Projet projet = projetRepository.findById(projetId).orElse(null);
        if (projet != null) {
            Float montantCollecte = projet.getMontantCollecte();
            if (projet.getMontant() != 0) {
                return (montantCollecte / projet.getMontant()) * 100;
            } else {
                throw new IllegalArgumentException("Le montant total du projet ne peut pas être zéro.");
            }
        } else {
            throw new IllegalArgumentException("Projet non trouvé.");
        }
    }


}
