package com.app.Service;

import com.app.Entity.Bloodgroup;
import com.app.Entity.Repository.bloodGroupRepository;

import com.app.Exception.bloodgroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bloodgroupService {
    @Autowired
    private bloodGroupRepository brepo;

    public Bloodgroup Bloodgroup(String bloodGroup) throws bloodgroupNotFoundException {
        Bloodgroup bloodgroup = brepo.findByBloodgroup(bloodGroup);
        if (bloodgroup != null) {
            return bloodgroup;
        } else {
            throw new bloodgroupNotFoundException("blood group not found :" + bloodgroup);
        }
    }
}

