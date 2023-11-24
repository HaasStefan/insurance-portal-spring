package com.ngjournal.insuranceportal.service;

import com.ngjournal.insuranceportal.domain.ContractStatus;
import com.ngjournal.insuranceportal.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class CancellationService {
    private final ContractRepository contractRepository;

    public CancellationService(final ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public boolean cancelContract(String policyNumber) {
        var contract = contractRepository.findByPolicyNumber(policyNumber);
        if (contract != null) {
            contract.setStatus(ContractStatus.Inactive);
            contractRepository.save(contract);
            return true;
        }
        return false;
    }
}
