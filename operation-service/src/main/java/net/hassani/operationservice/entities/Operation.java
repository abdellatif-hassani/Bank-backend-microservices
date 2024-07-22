package net.hassani.operationservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.hassani.operationservice.enums.TypeOperation;
import net.hassani.operationservice.model.Compte;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateOperation;
    private double montant;
    private TypeOperation typeOperation;
    private Long idCompte;
    @Transient
    private Compte compte;
}
