package com.example.BloodDonor.ServiceImplementation;

import com.example.BloodDonor.CustomException.AlreadyExistsException;
import com.example.BloodDonor.CustomException.CustomException;
import com.example.BloodDonor.CustomException.NotAcceptableException;
import com.example.BloodDonor.Entity.Address;
import com.example.BloodDonor.Entity.BloodGroup;
import com.example.BloodDonor.Entity.Donor;
import com.example.BloodDonor.Entity.Login;
import com.example.BloodDonor.Repository.DonorRepository;
import com.example.BloodDonor.Repository.LoginRepository;
import com.example.BloodDonor.Service.DonorService;
import com.example.BloodDonor.helper.DonorRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImplementation implements DonorService {
    @Autowired
    private DonorRepository donorRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private AddressServiceImplementation addressServiceImplementation;
    @Autowired
    private  BloodGroupServiceImplementation bloodGroupServiceImplementation;
    @Autowired
    private LoginServiceImplementation loginServiceImplementation;
    @Override
    public List<Donor> finddonorbyId(int addressid) {
        return donorRepository.findByAddress(addressid);

    }

    @Override
    public List<Donor> finddonorbyblood(int bloodid) {

        return donorRepository.findByBloodGroup(bloodid);
    }
    public List<Donor> findDonorDetails(int addressid,int bloodid){
        return donorRepository.findByAddressAndBloodGroup(addressid,bloodid);
    }

    @Override
    public Donor saveDonor(DonorRegistration donorRegistration) throws CustomException, NotAcceptableException, AlreadyExistsException {
        Donor donor=new Donor();
        donor.setFullname(donorRegistration.getFullname());
        if(donorRepository.existsByMobileNumber(donorRegistration.getMobile_number())){
            throw new NotAcceptableException("Data Is NotAcceptable");
        }
        else {
            donor.setMobileNumber(donorRegistration.getMobile_number());
        }
        donor.setAcknowledgement(true);
        donor.setAvailability(true);
        Address address=addressServiceImplementation.findAddress(donorRegistration.getCountry(),
                donorRegistration.getState(),
                donorRegistration.getDistrict(),
                donorRegistration.getCity());
        donor.setAddress(address);
        BloodGroup bloodGroup=bloodGroupServiceImplementation.getBloodgroup(donorRegistration.getBloodgroup());
        donor.setBloodGroup(bloodGroup);
        Login login=new Login();
        if(!donorRegistration.getPassword().equals(donorRegistration.getRetype_password())) {
            throw new NotAcceptableException("Data Is NotAcceptable");
        }else if(!(loginRepository.existsById(donorRegistration.getEmailid()))){
            throw new AlreadyExistsException("Email Id is Already there");
        }
        else{
            login.setEmail(donorRegistration.getEmailid());
            login.setPassword(donorRegistration.getPassword());
            loginServiceImplementation.addLogin(login);
        }
        donor.setLogin(login);
        return donorRepository.save(donor);
    }
}
