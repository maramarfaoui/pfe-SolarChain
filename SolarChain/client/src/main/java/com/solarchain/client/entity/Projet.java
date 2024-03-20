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
public class Projet implements Serializable {
    @Id
    private String projectId;
    private String projectName;
    private String image ;
    private String description;
    private Float montant;

    private Float montantCollecte;
    private Integer nbrJour ;
    private Status status ;


    @DBRef
    private Localisation localisation;

    @DBRef
    private List<ProjetFondRelation> relations;


}
