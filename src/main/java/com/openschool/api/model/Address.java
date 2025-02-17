package com.openschool.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String zipCode;

    private String state;

    private String city;

    private String neighborhood;

    private String street;

    private String number;
}
