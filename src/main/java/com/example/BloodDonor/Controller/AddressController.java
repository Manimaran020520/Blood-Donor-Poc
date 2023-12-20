package com.example.BloodDonor.Controller;

import com.example.BloodDonor.CustomException.CustomException;
import com.example.BloodDonor.Entity.Address;
import com.example.BloodDonor.Service.AddressService;
import com.example.BloodDonor.ServiceImplementation.AddressServiceImplementation;
import jakarta.persistence.Cacheable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Set;

@RestController
public class AddressController {
    Logger log= LoggerFactory.getLogger(AddressController.class);
    @Autowired
    private AddressServiceImplementation addressService;

    @GetMapping("/getCountry")
    public ResponseEntity<List<String>> getAllCountries(){
        log.info("Get controller class is running");
        return new ResponseEntity<>(addressService.getAllCountries(),HttpStatus.OK);
    }
    @PostMapping("/addAddress/")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return  new ResponseEntity<>(addressService.addAddressDetails(address),HttpStatus.CREATED);
    }
    @GetMapping("/getState")
    public ResponseEntity<List<String>> getAllStates(@RequestParam String Country){
        return new ResponseEntity<>(addressService.getAllStates(Country),HttpStatus.OK);
    }
    @GetMapping("/getdistrict")
    public ResponseEntity<List<String>> getAllDistricts(@RequestParam String State){
        return new ResponseEntity<>(addressService.getAllDistrict(State),HttpStatus.OK);
    }
    @GetMapping("/getCity")
    public ResponseEntity<List<String>> getAllCity(@RequestParam String District){
        return new ResponseEntity<>(addressService.getAllCities(District),HttpStatus.OK);
    }
   @GetMapping("/getAddressId")
   public ResponseEntity<Integer>  getAddressId(@RequestParam String city ){
        return new ResponseEntity<>(addressService.getAddressId(city),HttpStatus.OK);
    }


}
