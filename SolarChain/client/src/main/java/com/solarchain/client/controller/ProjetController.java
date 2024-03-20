package com.solarchain.client.controller;

import com.solarchain.client.entity.Projet;
import com.solarchain.client.services.Projet.IProjetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/projets")
public class ProjetController {

    @Autowired
    IProjetService iProjetService ;


    @PostMapping("/add/{offreId}")
    public ResponseEntity<String> addProjetIfOffreValide(@PathVariable String offreId, @RequestBody Projet projet) {
        if (iProjetService.addProjetIfOffreValide(offreId, projet)) {
            return new ResponseEntity<>("Projet ajouté avec succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("L'offre n'est pas valide", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{projetId}/assign-fond")
    public  ResponseEntity<?>  assignFondToProjet(@PathVariable("projetId") String projetId,
                                     @RequestParam("montant") Float montant) {
        try {
            Projet projet = iProjetService.assignFondToProjet(projetId, montant);
            return ResponseEntity.ok(projet);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projet non trouvé.");
        }

    }


    @GetMapping("/{projetId}/pourcentage")
    public ResponseEntity<?> calculatePercentage(@PathVariable("projetId") String projetId) {
        try {
            float pourcentage = iProjetService.calculatePercentage(projetId);
            return ResponseEntity.ok(pourcentage);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projet non trouvé.");
        }
    }

}
