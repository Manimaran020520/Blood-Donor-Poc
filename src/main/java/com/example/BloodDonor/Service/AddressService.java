package com.example.BloodDonor.Service;

import com.example.BloodDonor.Entity.Address;

import java.util.List;
import java.util.Set;

public interface AddressService {
    List<String> getAllCountries ();
    Address addAddressDetails(Address address);

    List<String> getAllStates(String country);
    List<String> getAllDistrict(String state);
    List<String> getAllDistrictsByContAndSta(String country,String state);
    List<String> getAllCities(String district);
    List<String> getcities(String country,String state,String district);
    int getAddressId(String city);
    Address findAddress(String country,String state,String district,String city);


}
