package com.ngjournal.insuranceportal.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    private String city;

    @NotNull
    private String street;

    @NotNull
    private String state;

    @NotNull
    private String zip;
}
