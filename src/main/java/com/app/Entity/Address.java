package com.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int address_id;
    @NotBlank(message = "city is must be in string")
    @Size(min=4,max=15,message = "the name must be greater than 3 lessthan 15")
	public String city;
	@NotBlank(message = "district is must be in the state")
	public String district;
	@NotBlank(message = "state is must be in the country")
	@Size(min=3,max=15,message = "the name must be greater than 3 lessthan 15")
	public String state;
	@NotBlank(message = "the countrycode is must be in string format")
	@Size(min=3,max=5,message = "invalid input")
	public String countryCode;
	@NotBlank(message = "country is valid")
	public String country;


	public Address(String country1) {
	}
}
