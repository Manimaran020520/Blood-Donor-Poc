package com.example.BloodDonor.Service;

import com.example.BloodDonor.Entity.BloodGroup;

import java.util.List;

public interface BloodGroupService {
    BloodGroup addBloodGroup(BloodGroup bloodGroup);
    List<String> getAllBloodGroup();
    int getBloodGroup(String bloodid);
    BloodGroup getBloodgroup(String bloodgroup);


}
