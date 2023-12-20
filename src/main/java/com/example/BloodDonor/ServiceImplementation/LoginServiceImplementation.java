package com.example.BloodDonor.ServiceImplementation;

import com.example.BloodDonor.Entity.Login;
import com.example.BloodDonor.Repository.LoginRepository;
import com.example.BloodDonor.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Override
    public Login addLogin(Login login) {
        return loginRepository.save(login);
    }
}
