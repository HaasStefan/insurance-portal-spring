package com.ngjournal.insuranceportal.repository;

import com.ngjournal.insuranceportal.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
