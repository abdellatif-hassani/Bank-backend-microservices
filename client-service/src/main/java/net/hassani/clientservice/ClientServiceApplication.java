package net.hassani.clientservice;

import net.hassani.clientservice.entities.Client;
import net.hassani.clientservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, RepositoryRestConfiguration rrc) {
        return args -> {
            rrc.exposeIdsFor(Client.class);
            clientRepository.save(new Client(null, "Hassani", "hassani@gmail.com"));
            clientRepository.save(new Client(null, "anassi", "anassi@gmail.com"));
            clientRepository.save(new Client(null, "karimi", "karimi@gmail.com"));
            clientRepository.save(new Client(null, "alami", "alami@gmail.com"));
            clientRepository.findAll().forEach(System.out::println);
        };
    }
}
