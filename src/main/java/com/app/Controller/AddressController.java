package com.app.Controller;

import com.app.Entity.Address;
import com.app.Entity.Bloodgroup;
import com.app.Exception.DataNotFoundException;
import com.app.Service.addressService;
import com.app.Service.bloodgroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private bloodgroupService bserv;
    @Autowired
    private addressService aserv;

    @PostMapping("/address")
    public ResponseEntity<Address>saveAddress(@RequestBody  @Valid Address address){
        return new ResponseEntity<>(aserv.saveData(address), HttpStatus.CREATED);
    }
    @GetMapping("/getContrys")
    public ResponseEntity<List<String>>getAllCountrys(){
        return new ResponseEntity<>(aserv.getcountry(),HttpStatus.OK);
    }
    @GetMapping("/getStates")
    public  ResponseEntity<List<String>>getAllSates(@RequestParam  String country) throws DataNotFoundException {
        return new ResponseEntity<>(aserv.getState(country),HttpStatus.OK);
    }
    @GetMapping("/getdistricts/{state}")
    public  ResponseEntity<List<String>> getAllDistricts(@PathVariable String state){
        return new ResponseEntity<>(aserv.getDist(state),HttpStatus.OK);
    }
    @GetMapping ("/getCities/{district}")
    public ResponseEntity<List<String>> getAllCities(@PathVariable String district){
        return new ResponseEntity<>(aserv.getcity(district),HttpStatus.OK);
    }


}
