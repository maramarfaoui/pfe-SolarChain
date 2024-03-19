package com.solarchain.client.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OffreClient implements Serializable {
    @Id
    private String offre_id;
    private Integer superficie ;
    private boolean valide ;
    @DBRef
    private List<Consommation> consommations;

    @DBRef
    private Localisation localisation;
}
