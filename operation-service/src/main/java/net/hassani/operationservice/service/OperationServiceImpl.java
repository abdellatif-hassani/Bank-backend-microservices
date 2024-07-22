package net.hassani.operationservice.service;

import jakarta.transaction.Transactional;
import net.hassani.operationservice.entities.Operation;
import net.hassani.operationservice.enums.TypeOperation;
import net.hassani.operationservice.model.Compte;
import net.hassani.operationservice.model.CompteUpdateRequest;
import net.hassani.operationservice.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class OperationServiceImpl implements IOperationService {
    private OperationRepository operationRepository;
    private CompteService compteService;

    public OperationServiceImpl(OperationRepository operationRepository, CompteService compteService) {
        this.operationRepository = operationRepository;
        this.compteService = compteService;
    }

    @Override
    public void versment(Long id, double montant) {
        Compte compte = compteService.getCompteById(id);
        Operation operation = new Operation();
        operation.setMontant(montant);
        operation.setDateOperation(new Date());
        operation.setIdCompte(compte.getId());
        operation.setTypeOperation(TypeOperation.VERSEMENT);
        operationRepository.save(operation);
        compteService.updateCompte(new CompteUpdateRequest(id, compte.getSolde() + montant));
    }

    @Override
    public void retrait(Long id, double montant) {
        Compte compte = compteService.getCompteById(id);
        if (compte.getSolde() < montant) throw new RuntimeException("Solde insuffisant");
        else {
            Operation operation = new Operation();
            operation.setMontant(montant);
            operation.setDateOperation(new Date());
            operation.setIdCompte(compte.getId());
            operation.setTypeOperation(TypeOperation.RETRAIT);
            operationRepository.save(operation);
            compteService.updateCompte(new CompteUpdateRequest(id, compte.getSolde() - montant));
        }
    }

    @Override
    public void verment(Long id1, Long id2, double montant) {
        retrait(id1, montant);
        versment(id2, montant);
    }
}
