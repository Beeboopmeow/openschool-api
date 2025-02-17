package com.openschool.api.model;

import com.openschool.api.model.dtos.request.AddressRequestDTO;
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

    public Address(AddressRequestDTO addressData) {
        this.zipCode = addressData.zipCode();
        this.state = addressData.state();
        this.city = addressData.city();
        this.neighborhood = addressData.neighborhood();
        this.street = addressData.street();
        this.number = addressData.number();
    }
}
