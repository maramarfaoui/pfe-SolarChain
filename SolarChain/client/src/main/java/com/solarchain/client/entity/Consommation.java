package com.solarchain.client.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Consommation implements Serializable {
    @Id
    private String id;
    private Date date_debut ;
    private Date date_fin ;
    private Float montant ;
    private String facture ;
}
