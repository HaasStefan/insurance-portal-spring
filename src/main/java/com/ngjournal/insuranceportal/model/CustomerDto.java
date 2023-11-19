package com.ngjournal.insuranceportal.model;

import lombok.Data;

@Data
public class CustomerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private AddressDto address;
}
