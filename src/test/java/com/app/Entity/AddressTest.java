package com.app.Entity;



import com.app.Entity.Repository.addressRepository;
import com.app.Service.addressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AddressTest {
    @Mock
    private addressRepository arepo;
    @InjectMocks
    private addressService aserv;

    @Test
    public void testAddressFields() {
        Address address = new Address();
        address.setCity("city");
        address.setDistrict("district");
        address.setState("state");
        address.setCountry("country");
        address.setCountryCode("countrycode");

        assertEquals("city", address.getCity());
        assertEquals("district", address.getDistrict());
        assertEquals("state", address.getState());
        assertEquals("country", address.getCountry());
        assertEquals("countrycode", address.getCountryCode());
    }

    @Test
    void getcities() {
        List<Address> citys = new ArrayList<>();
//citys[]      //  List<Address> city = new ArrayList<>();
        //citys.add("npeta");
        //citys.add("PALASA");
        when(arepo.findByDistrict(any())).thenReturn(citys);//2
        List<String> results = aserv.getcity("ap");//1
        assertNotNull(results);
    }
    @Test

    void getdistricts() {
        List<String> districtlist = new ArrayList<>();
        List<Address> districts = new ArrayList<>();
        districtlist.add("SKLM");
        districtlist.add("VZM");
        when(arepo.findByState(any())).thenReturn(districts);
        List<String> results = aserv.getDist("AP");
        assertNotNull(results);

    }
    @Test
void getcountrys(){

        Address address=new Address();
        List<Address> countrys =new ArrayList<>();
        when(arepo.findAll()).thenReturn(countrys);
        List<String> results =aserv.getcountry();
        assertNotNull(results);
}

    @Test
    void saveData(){
        Address address= new Address();
        when(arepo.save(any())).thenReturn(address);
        Address savedAddress=aserv.saveData(address);
        assertEquals(address,savedAddress);

    }
    @Test
    void testfindaddress(){
        String country="country";
        String state ="state";
        String district="district";
        String city ="city";
        Address address= new Address();
        when(arepo.findByCountryAndStateAndDistrictAndCity(country,state,district,city)).thenReturn(address);
        Address results= aserv.findAddress(country,state,district,city);
        assertNotNull(results);
    }
}


