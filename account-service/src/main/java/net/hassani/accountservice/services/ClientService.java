package net.hassani.accountservice.services;

import net.hassani.accountservice.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client-service")
public interface ClientService {
    @GetMapping("/clients/{id}?projection=pc1")
    public Client getClientById(@PathVariable Long id);

    @GetMapping("/clients")
    PagedModel<Client> findAll();
}
