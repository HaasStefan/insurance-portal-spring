package com.ngjournal.insuranceportal.service;

import com.ngjournal.insuranceportal.domain.Customer;
import com.ngjournal.insuranceportal.model.CustomerDto;
import com.ngjournal.insuranceportal.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(final CustomerRepository customerRepository, final ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDto[] getAll() {
        return modelMapper.map(customerRepository.findAll(), CustomerDto[].class);
    }

    public CustomerDto get(String id) {
        // todo not found exception
        return modelMapper.map(customerRepository.findById(id).orElseThrow(), CustomerDto.class);
    }

    public CustomerDto create(final CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }
}