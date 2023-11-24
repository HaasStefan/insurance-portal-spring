package com.ngjournal.insuranceportal.service;

import com.ngjournal.insuranceportal.domain.Contract;
import com.ngjournal.insuranceportal.domain.ContractStatus;
import com.ngjournal.insuranceportal.repository.ContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CancellationServiceTests {
    @MockBean
    private ContractRepository contractRepository;

    @Autowired
    private CancellationService cancellationService;


    @Test
    public void shouldCancelContract() {
        // arrange
        var policyNumber = "123";

        var contract = new Contract();
        contract.setPolicyNumber(policyNumber);
        contract.setStatus(ContractStatus.Active);
        contract.setCustomerId("555");
        contract.setInsuranceStartOn(new Date());
        contract.setId("id-123");

        when(contractRepository.findByPolicyNumber(policyNumber)).thenReturn(contract);
        when(contractRepository.save(contract)).thenReturn(contract);

        // act
        var isContractCanceled = cancellationService.cancelContract(policyNumber);

        // assert
        assertTrue(isContractCanceled);

    }
}
