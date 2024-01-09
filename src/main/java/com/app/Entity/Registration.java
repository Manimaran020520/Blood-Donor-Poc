package com.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private String name;
    private String bloodGroup;
    private String mobileNumber;
    private String country;
    private String state;
    private String district;
    private String city;
    private String emailid;
    private String password;
    private String RetypePassword;



}
