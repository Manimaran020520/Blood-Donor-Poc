package com.example.BloodDonor.ServiceTest;

import com.example.BloodDonor.CustomException.DataNotFoundException;
import com.example.BloodDonor.Entity.Address;
import com.example.BloodDonor.Repository.AddressRepository;
import com.example.BloodDonor.Service.AddressService;
import com.example.BloodDonor.ServiceImplementation.AddressServiceImplementation;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTEst {
    Logger log= LoggerFactory.getLogger(ServiceTEst.class);
    @Mock
    AddressRepository addressRepository;
    @InjectMocks
    AddressServiceImplementation addressService;

    @Test
    public void getAllCountries(){
       List<String> countries=new ArrayList<>();
       countries.add("India");
       countries.add("Nepal");
       countries.add("Japan");
        when(addressRepository.findcountries()).thenReturn(countries);
        List<String> result=addressService.getAllCountries();
        assertEquals(3,result.size());

    }
    @Test
    public void getAllStatesTest()  {

        List<String> states=new ArrayList<>();
        states.add("Goa");
        states.add("Punjab");
        states.add("Gujarat");
        when(addressRepository.existsByCountry(any())).thenReturn(true);
        when(addressRepository.findByCountry(any())).thenReturn(states);
        List<String> results=addressService.getAllStates("India");
        assertEquals(states,results);
    }
    @Test(expected=DataNotFoundException.class)
    public void getAllStatesTestFail() {
        List<String> states=new ArrayList<>();
        states.add("Goa");
        states.add("Punjab");
        states.add("Gujarat");
        when(addressRepository.existsByCountry(any())).thenReturn(false);

    }

    @Test
    public void getAllDistrict(){
        List<String> addresses=new ArrayList<>();
        addresses.add("Chennai");
        addresses.add("Trichy");
        addresses.add("Ariyalur");
        when(addressRepository.findByState(any())).thenReturn(addresses);
        List<String> results=addressService.getAllDistrict("Assam");
        assertNotNull(results);

    }
    @Test
    public void getAllCities(){
        List<String> cities=new ArrayList<>();
        cities.add("T.Nagar");
        cities.add("Velachery");
        when(addressRepository.findByDistrict(any())).thenReturn(cities);
        List<String> results=addressService.getAllCities("TamilNadu");
        assertNotNull(results);
    }


}
