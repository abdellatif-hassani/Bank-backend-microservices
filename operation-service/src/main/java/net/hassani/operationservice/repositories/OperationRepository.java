package net.hassani.operationservice.repositories;

import net.hassani.operationservice.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
