package net.hassani.accountservice.web;

import net.hassani.accountservice.entities.Compte;
import net.hassani.accountservice.model.Client;
import net.hassani.accountservice.model.CompteUpdateRequest;
import net.hassani.accountservice.repositories.CompteRepository;
import net.hassani.accountservice.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompteRestController {
    private CompteRepository compteRepository;
    private ClientService clientService;

    public CompteRestController(CompteRepository compteRepository, ClientService clientService) {
        this.compteRepository = compteRepository;
        this.clientService = clientService;
    }

    @GetMapping("/fullComptes/{id}")
    public Compte getCompteById(@PathVariable(value = "id") Long id) {
        Compte compte = compteRepository.findById(id).get();
        Client client = clientService.getClientById(compte.getId());
        compte.setClient(client);
        return compte;
    }

    @GetMapping("listClients")
    public List<Client> findAllClients() {
        return clientService.findAll().getContent().stream().toList();
    }

//    updateCompte
    @PutMapping("/updateCompte")
    public void updateCompte(@RequestBody CompteUpdateRequest compteUpdateRequest) {
        Compte compte = compteRepository.findById(compteUpdateRequest.getId()).get();
        compte.setSolde(compteUpdateRequest.getSolde());
        compteRepository.save(compte);
    }
}
