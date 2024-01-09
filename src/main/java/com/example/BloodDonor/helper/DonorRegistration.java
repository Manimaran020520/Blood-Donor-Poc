package com.example.BloodDonor.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonorRegistration {
    private String fullname;
    private long mobile_number;
    private String emailid;
    private String password;
    private String retype_password;
    private String country;
    private String state;
    private String district;
    private String city;
    private String bloodgroup;

}
