package net.hassani.operationservice.service;

import net.hassani.operationservice.model.Compte;
import net.hassani.operationservice.model.CompteUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-service")
public interface CompteService {
    @GetMapping("/comptes/{id}?projection=pc1")
    public Compte getCompteById(@PathVariable Long id);
    @PutMapping("/updateCompte")
    public void updateCompte(@RequestBody CompteUpdateRequest compteUpdateRequest);
}
