package com.example.BloodDonor.Service;

import com.example.BloodDonor.CustomException.AlreadyExistsException;
import com.example.BloodDonor.CustomException.NotAcceptableException;
import com.example.BloodDonor.Entity.Donor;
import com.example.BloodDonor.helper.DonorRegistration;

import java.util.List;

public interface DonorService {
List<Donor> finddonorbyId(int addressid);
List<Donor> finddonorbyblood(int bloodid);
List<Donor> findDonorDetails(int addressid,int bloodid);

Donor saveDonor(DonorRegistration donorRegistration) throws NotAcceptableException, AlreadyExistsException;

}
