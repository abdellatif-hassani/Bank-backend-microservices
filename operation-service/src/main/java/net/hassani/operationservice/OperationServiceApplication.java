package net.hassani.operationservice;

import net.hassani.operationservice.service.IOperationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OperationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IOperationService operationService) {
        return args -> {
            operationService.versment(1L, 11000);
            operationService.versment(2L, 2000);
            operationService.retrait(1L, 500);
            operationService.verment(1L, 2L, 1500);
        };
    }
}
