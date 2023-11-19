package com.ngjournal.insuranceportal.service;

import com.ngjournal.insuranceportal.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDto create(final CustomerDto customerDto);
}
