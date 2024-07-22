package net.hassani.operationservice.service;

public interface IOperationService {
    void versment(Long id, double montant);
    void retrait(Long id, double montant);
    void verment (Long id1, Long id2, double montant);
}
