package com.example.BloodDonor.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressid;
    private String city;
    private String district;
    private String state;
    private String country;
    private String countrycode;


}
