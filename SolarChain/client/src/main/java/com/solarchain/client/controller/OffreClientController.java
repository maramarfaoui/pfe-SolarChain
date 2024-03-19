package com.solarchain.client.controller;

import com.solarchain.client.entity.Client;
import com.solarchain.client.entity.OffreClient;
import com.solarchain.client.services.OffreClient.IOffreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/offres")
public class OffreClientController {

    IOffreService iOffreService ;

    @PostMapping("addoffre")
    public OffreClient add (@RequestBody OffreClient c){
        log.info("addig");
        return  iOffreService.addOffre(c);
    }
    @PutMapping("/{id}/approve")
    public ResponseEntity<Void> approveOffreClient(@PathVariable String id) {
        OffreClient offreClient = iOffreService.findById(id);
        if (offreClient != null) {
            iOffreService.approveOffre(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
