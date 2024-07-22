package net.hassani.operationservice.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class CompteUpdateRequest {
    private Long id;
    private double solde;
}
