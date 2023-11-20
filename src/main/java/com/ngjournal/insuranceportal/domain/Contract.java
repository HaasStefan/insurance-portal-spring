package com.ngjournal.insuranceportal.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    private String policyNumber;

    @NotNull
    private Date insuranceStartOn;

    @NotNull
    private String customerId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ContractStatus status;
}

