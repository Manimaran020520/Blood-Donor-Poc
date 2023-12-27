package com.app.Controller;

import java.util.List;

import com.app.Entity.Bloodgroup;
import com.app.Entity.Registration;
import com.app.Exception.bloodgroupNotFoundException;
import com.app.Service.bloodgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Donors;

import com.app.Service.donorService;

@RestController
public class donorsController {
	@Autowired
	private donorService dserv;
	@Autowired
	private bloodgroupService bserv;

	@PostMapping("/saveData")
    public ResponseEntity<Donors> saveDonors(@RequestBody Donors donors) {
       return new ResponseEntity<>(dserv.saveData(donors), HttpStatus.CREATED);
    }
	@GetMapping("/alldata")
	public ResponseEntity<List<Donors>> allData(){
	return new ResponseEntity<>(dserv.getallData(),HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/getDonorDatas/{addressid}/{bloodid}")
	public ResponseEntity<Donors> getallDatas(@PathVariable int addressid,@PathVariable int bloodid){
		return  new ResponseEntity<>(dserv.getDonordetails(addressid, bloodid),HttpStatus.OK);
	}
	@PostMapping("/addDonors")
	public ResponseEntity<Donors> addDonors(@RequestBody Registration registration) throws bloodgroupNotFoundException {
		return  new ResponseEntity<>(dserv.saveDonor(registration),HttpStatus.CREATED);
	}
@GetMapping("/{bloodGroup}")
    public ResponseEntity<Bloodgroup> getdetails(@PathVariable String bloodGroup) throws bloodgroupNotFoundException {
		return new ResponseEntity<>(bserv.Bloodgroup(bloodGroup),HttpStatus.ACCEPTED);
}

}
