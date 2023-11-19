package com.ngjournal.insuranceportal.service;

import com.ngjournal.insuranceportal.domain.Customer;
import com.ngjournal.insuranceportal.model.CustomerDto;
import com.ngjournal.insuranceportal.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public DefaultCustomerService(final CustomerRepository customerRepository, final ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto create(final CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }
}