package com.example.BloodDonor.ServiceImplementation;

import com.example.BloodDonor.CustomException.DataNotFoundException;
import com.example.BloodDonor.Entity.Address;
import com.example.BloodDonor.Repository.AddressRepository;
import com.example.BloodDonor.Service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service

public class AddressServiceImplementation implements AddressService {
    private static final Logger log= LoggerFactory.getLogger(AddressServiceImplementation.class);
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<String> getAllCountries() {
        log.info("get all service class is running");

        List<String> list= addressRepository.findcountries();
        return list;
    }

    @Override
    public Address addAddressDetails(Address address) {
        String City=address.getCity();
        if(!addressRepository.existsByCity(City)){
           return addressRepository.save(address);
        }
        return address;
    }

    @Override
    public List<String> getAllStates(String country) throws DataNotFoundException{
        if (!(addressRepository.existsByCountry(country))) {
            log.warn("The country is not found "+country);
            throw new DataNotFoundException("Country is not present");

        } else {
            List<String> states=addressRepository.findByCountry(country);
            return states;
        }
    }

    @Override
    public List<String> getAllDistrict(String state) {
        if (!(addressRepository.existsByState(state))) {
            log.warn("The state is not found"+state);
            throw new DataNotFoundException("state is not present");

        } else {

            List<String> districts = addressRepository.findByState(state);
            return districts;
        }
    }

    @Override
    public List<String> getAllDistrictsByContAndSta(String country, String state) {
        List<Address> districtlist=addressRepository.findByCountryAndState(country,state);
        Set<String> set=new HashSet<>();
        for(Address ad:districtlist){
            set.add(ad.getDistrict());
        }
        List<String> districts=set.stream().toList();
        return districts;
    }

    @Override

    public List<String> getAllCities(String district) {
        if (!(addressRepository.existsByDistrict(district))){

            throw new DataNotFoundException("District is not present");

        }else{
        List<String> cities=addressRepository.findByDistrict(district);
        return cities;
    }
    }


    @Override
    public List<String> getcities(String country, String state, String district) {

        List<String> cities=addressRepository.findByCountryAndStateAndDistrict(country, state, district);
        return cities;
    }

    @Override
    public int getAddressId( String city) {
        if (!(addressRepository.existsByCity(city))) {
            throw new DataNotFoundException("City is not present");

        }
        else {
            Address address = addressRepository.findByCity(city);
            System.out.println(address.getAddressid());
            return address.getAddressid();
        }
    }

    @Override
    public Address findAddress(String country, String state, String district, String city) {
        return addressRepository.findByCountryAndStateAndDistrictAndCity(country, state, district, city);
    }



}
