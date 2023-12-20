package com.example.BloodDonor.Controller;

import com.example.BloodDonor.CustomException.AlreadyExistsException;
import com.example.BloodDonor.CustomException.NotAcceptableException;
import com.example.BloodDonor.Entity.Donor;
import com.example.BloodDonor.Service.DonorService;
import com.example.BloodDonor.ServiceImplementation.DonorServiceImplementation;
import com.example.BloodDonor.helper.DonorRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorController {
    @Autowired
    private DonorServiceImplementation donorService;
    @GetMapping("/getDonors/{addressid}")
    public ResponseEntity<List<Donor>> getbyAddressId(@PathVariable int addressid)
    {
        return new ResponseEntity<List<Donor>>(donorService.finddonorbyId(addressid),HttpStatus.OK);
    }
    @GetMapping("/getDonorsByBlood/{bloodid}")
    public ResponseEntity<List<Donor>> getbyBloodId(@PathVariable int bloodid){
        return new ResponseEntity<>(donorService.finddonorbyblood(bloodid),HttpStatus.OK);
    }
    @GetMapping("/getDonorsData/{addressid}/{bloodid}")
    public ResponseEntity<List<Donor>> getDonordetails(@PathVariable int addressid,@PathVariable int bloodid)
    {
        return new ResponseEntity<>(donorService.findDonorDetails(addressid,bloodid),HttpStatus.OK);
    }
    @PostMapping("/adddonors/")
    public ResponseEntity<Donor> addDonorDetails(@RequestBody DonorRegistration donorRegistration) throws NotAcceptableException, AlreadyExistsException {
       return new ResponseEntity<>(donorService.saveDonor(donorRegistration),HttpStatus.CREATED);

    }
}
