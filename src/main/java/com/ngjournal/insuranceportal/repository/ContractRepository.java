package com.ngjournal.insuranceportal.repository;

import com.ngjournal.insuranceportal.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {
}
