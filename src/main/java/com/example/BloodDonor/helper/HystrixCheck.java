package com.example.BloodDonor.helper;

import com.example.BloodDonor.Entity.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HystrixCheck {
    public String heading;
    public BloodGroup bloodGroup;
}
