package com.example.BloodDonor.Controller;


import com.example.BloodDonor.Entity.BloodGroup;
import com.example.BloodDonor.Service.BloodGroupService;
import com.example.BloodDonor.ServiceImplementation.BloodGroupServiceImplementation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.List;

@RestController

public class BloodGroupController implements Serializable {
    Logger log= LoggerFactory.getLogger(BloodGroupController.class);

    @Autowired
    private BloodGroupServiceImplementation bloodGroupServiceImplementation;
    @PostMapping("/addBloodGroup")
    public ResponseEntity<BloodGroup> addBloodgroups(@RequestBody BloodGroup bloodGroup)
    {
        return  new ResponseEntity<>(bloodGroupServiceImplementation.addBloodGroup(bloodGroup), HttpStatus.OK);
    }
    @GetMapping("/getAllBloodGroups")
    public ResponseEntity<List<String>> getBloodGroups(){
        return new ResponseEntity<>(bloodGroupServiceImplementation.getAllBloodGroup(),HttpStatus.OK);
    }
    @GetMapping("/getBloodid/{bloodGroup}")
    public ResponseEntity<Integer> getBloodGroup(@PathVariable String bloodGroup)
    {
        log.info(bloodGroup);
        return new ResponseEntity<>(bloodGroupServiceImplementation.getBloodGroup(bloodGroup),HttpStatus.OK);
    }
    @GetMapping("/getbyid/{bloodid}")
    public ResponseEntity<BloodGroup> getBloodDetails(@PathVariable int bloodid){
        return new ResponseEntity<>(bloodGroupServiceImplementation.getBloodDetail(bloodid),HttpStatus.OK);
    }
}
