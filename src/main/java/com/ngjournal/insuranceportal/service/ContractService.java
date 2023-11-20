package com.ngjournal.insuranceportal.service;

import com.ngjournal.insuranceportal.domain.Contract;
import com.ngjournal.insuranceportal.model.ContractDto;
import com.ngjournal.insuranceportal.repository.ContractRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ModelMapper modelMapper;

    public ContractService(final ContractRepository contractRepository, final ModelMapper modelMapper) {
        this.contractRepository = contractRepository;
        this.modelMapper = modelMapper;
    }

    public ContractDto create(final ContractDto contractDto) {
        Contract contract = modelMapper.map(contractDto, Contract.class);
        return modelMapper.map(contractRepository.save(contract), ContractDto.class);
    }

    public ContractDto update(final ContractDto contractDto) {
        Contract contract = modelMapper.map(contractDto, Contract.class);
        return modelMapper.map(contractRepository.save(contract), ContractDto.class);
    }

    public ContractDto get(final String id) {
        return modelMapper.map(contractRepository.findById(id).orElseThrow(), ContractDto.class);
    }

    public ContractDto[] getAll() {
        return modelMapper.map(contractRepository.findAll(), ContractDto[].class);
    }

    // todo implement cancel contract
}
