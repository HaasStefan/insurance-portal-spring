package com.ngjournal.insuranceportal.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String phone;

    @Email
    @NotNull
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
}
