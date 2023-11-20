package com.ngjournal.insuranceportal.controller;

import com.ngjournal.insuranceportal.model.ContractDto;
import com.ngjournal.insuranceportal.service.ContractService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contracts")
public class ContractController {
    private final ContractService contractService;

    public ContractController(final ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping
    public ContractDto createContract(@RequestBody ContractDto contract) {
        return contractService.create(contract);
    }

    @PutMapping
    public ContractDto updateContract(@RequestBody ContractDto contract) {
        return contractService.update(contract);
    }

    @GetMapping("/{id}")
    public ContractDto getContract(@PathVariable String id) {
        return contractService.get(id);
    }

    @GetMapping
    public ContractDto[] getAllContracts() {
        return contractService.getAll();
    }
}
