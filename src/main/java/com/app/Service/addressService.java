package com.app.Service;

import com.app.Entity.Address;
import com.app.Entity.Repository.addressRepository;
import com.app.Exception.DataNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class addressService {
    @Autowired
    private addressRepository arepo;
    public Address saveData(Address address){
        return arepo.save(address);
    }

    public  Address findAddress(String country, String state, String district, String city){
        return arepo.findByCountryAndStateAndDistrictAndCity(country,state,district,city);
    }


    public List<String> getcountry(){
        List<Address> addressList=arepo.findAll();
        Set<String> country=new HashSet<>();
        for(Address ad:addressList){
            country.add(ad.getCountry());
        }
        return country.stream().toList();
    }
    public List<String> getState(String country) throws DataNotFoundException {

        List<Address> statesList = arepo.findByCountry(country);
        if(statesList.isEmpty()){
           throw new DataNotFoundException("No data found for :"+country);
       }else{
        Set<String> stateSet=statesList.stream().map(Address::getState).collect(Collectors.toSet());
        return List.copyOf(stateSet);

      
        }
    }
    public List<String> getDist(String district){
        List<Address> districtList=arepo.findByState(district);
        Set<String> districts=new HashSet<>();
        for(Address ad:districtList){
            districts.add(ad.getDistrict());
        }
        return districts.stream().toList();
    }
    public List<String> getcity(String city) {
        List<Address> cityList = arepo.findByDistrict(city);
        Set<String> districts = new HashSet<>();
        for (Address ad : cityList) {
            districts.add(ad.getCity());
        }
        return districts.stream().toList();
    }
}
