package net.hassani.accountservice.entities;

import jakarta.persistence.*;
import net.hassani.accountservice.enums.EtatCompte;
import net.hassani.accountservice.enums.TypeCompte;
import net.hassani.accountservice.model.Client;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "pc1", types = Compte.class)
public interface CompteProjection {
    public Long getId();
    public double getSolde();
    public Date getDateCreation();
    public TypeCompte getType();
    public EtatCompte getEtat();
    public Client getClient();
}
