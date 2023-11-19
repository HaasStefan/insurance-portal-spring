package com.ngjournal.insuranceportal.model;

import lombok.Data;

@Data
public class AddressDto {
    private String id;
    private String city;
    private String street;
    private String state;
    private String zip;
}
