package net.hassani.accountservice.model;

import lombok.Data;

@Data
public class CompteUpdateRequest {
    private Long id;
    private double solde;
}
