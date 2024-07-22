package net.hassani.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.hassani.accountservice.enums.EtatCompte;
import net.hassani.accountservice.enums.TypeCompte;
import net.hassani.accountservice.model.Client;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private TypeCompte type;
    private EtatCompte etat;
    @Transient private Client client;
    private Long idClient;
}
