package com.ngjournal.insuranceportal.controller;

import com.ngjournal.insuranceportal.model.CustomerDto;
import com.ngjournal.insuranceportal.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customer) {
        return customerService.create(customer);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public CustomerDto[] getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable String id) {
        return customerService.get(id);
    }
}
