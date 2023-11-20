package com.ngjournal.insuranceportal.model;

import lombok.Data;

@Data
public class ContractDto {
    private String id;
    private String policyNumber;
    private String insuranceStartOn;
    private String customer;
    private ContractStatusDto status;
}
