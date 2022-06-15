package com.example.springdockerexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    
    private String country;
    private String postCode;
    private String city;
    public Address(String country, String postCode, String city) {
        this.country = country;
        this.postCode = postCode;
        this.city = city;
    }
}
