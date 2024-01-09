package com.app.Service;

import com.app.Entity.Login;
import com.app.Entity.Repository.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    @Autowired
    private loginRepository lrepo;
    public Login save(Login login){
        return lrepo.save(login);
    }
}
