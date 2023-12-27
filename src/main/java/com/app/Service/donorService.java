package com.app.Service;

import java.util.List;

import com.app.Entity.*;

import com.app.Exception.bloodgroupNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Repository.donorRepository;
@Slf4j
@Service
public class donorService {
	@Autowired
	private donorRepository drepo;
	@Autowired
	private addressService aserv;
	@Autowired
	private bloodgroupService bserv;

	@Autowired
	private loginService lserv;

	public Donors saveData(Donors donors){
		return drepo.save(donors);
	}
	public  List<Donors> getallData(){
		return drepo.findAll();
	}

	public Donors getDonordetails(int addressid,int bloodid){
		return drepo.findByAddressAndBloodGroup(addressid, bloodid);
	}
	public Donors saveDonor(Registration registration) throws bloodgroupNotFoundException {
		Donors donors = new Donors();
		donors.setName(registration.getName());
		donors.setMobile_number(registration.getMobileNumber());
		donors.setAcknowledgement(true);
		donors.setAvailability("true");
		log.info("{}",registration.getName());
		Address address =new Address();
		address=aserv.findAddress(registration.getCountry(), registration.getState(), registration.getDistrict(), registration.getCity());
		log.info("{}",address);
		donors.setAddress(address);
		Bloodgroup bloodGroup =new Bloodgroup();
		bloodGroup=bserv.Bloodgroup(registration.getBloodGroup());
		donors.setBloodGroup(bloodGroup);
		Login login=new Login();
		login.setPassword(registration.getPassword());
		login.setEmailId(registration.getEmailid());
		login=lserv.save(login);
		donors.setLogin(login);
		return drepo.save(donors);
	}

	}


