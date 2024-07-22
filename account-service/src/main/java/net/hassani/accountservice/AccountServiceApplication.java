package net.hassani.accountservice;

import net.hassani.accountservice.entities.Compte;
import net.hassani.accountservice.enums.EtatCompte;
import net.hassani.accountservice.enums.TypeCompte;
import net.hassani.accountservice.model.Client;
import net.hassani.accountservice.repositories.CompteRepository;
import net.hassani.accountservice.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientService clientService,
            RepositoryRestConfiguration rrc) {
        return args -> {
            rrc.exposeIdsFor(Compte.class);
            Client client1 = clientService.getClientById(1L);
            System.out.println("*******************");
            System.out.println(client1.getId());
            System.out.println(client1.getName());
            System.out.println(client1.getEmail());
            System.out.println("*******************");
            Client client2 = clientService.getClientById(2L);
            System.out.println("*******************");
            System.out.println(client2.getId());
            System.out.println(client2.getName());
            System.out.println(client2.getEmail());
            System.out.println("*******************");
            Compte compte1 = Compte.builder().solde(1000).dateCreation(new Date()).type(TypeCompte.COURANT).etat(EtatCompte.BLOCKED).idClient(client1.getId()).build();
            Compte compte2 = Compte.builder().solde(2000).dateCreation(new Date()).type(TypeCompte.EPARGNE).etat(EtatCompte.ACTIVE).idClient(client2.getId()).build();
            Compte compte3 = Compte.builder().solde(3000).dateCreation(new Date()).type(TypeCompte.COURANT).etat(EtatCompte.SUSPENDUE).idClient(1L).build();
            compteRepository.save(compte1);
            compteRepository.save(compte2);
            compteRepository.save(compte3);
            compteRepository.findAll().forEach(System.out::println);
        };
    }
}
