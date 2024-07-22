package net.hassani.operationservice.model;

import lombok.Data;

@Data
public class Compte {
    private Long id;
    private double solde;
    private String typeCompte;
}
