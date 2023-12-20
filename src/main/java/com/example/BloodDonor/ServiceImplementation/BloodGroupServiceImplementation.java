package com.example.BloodDonor.ServiceImplementation;

import com.example.BloodDonor.Entity.BloodGroup;
import com.example.BloodDonor.Repository.BloodGroupRepository;
import com.example.BloodDonor.Service.BloodGroupService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service

public class BloodGroupServiceImplementation implements BloodGroupService, Serializable {


    @Autowired
    private BloodGroupRepository bloodGroupRepository;
    @Override
    public BloodGroup addBloodGroup(BloodGroup bloodGroup) {

        return bloodGroupRepository.save(bloodGroup);

    }

    @Override
    public List<String> getAllBloodGroup() {
        List<String> bloodgroups=new ArrayList<>();
        List<BloodGroup> bloodGroupList=bloodGroupRepository.findAll();
        for(BloodGroup bg:bloodGroupList){
            bloodgroups.add(bg.getBloodgroup());
            }
            return bloodgroups;
        }

        @Override
        public int getBloodGroup(String bloodgroup) {

            return bloodGroupRepository.findByBloodgroup(bloodgroup);
    }


    @Override
    public BloodGroup getBloodgroup(String bloodgroup) {
        log.info(bloodgroup);

        return bloodGroupRepository.findBloodGroup(bloodgroup);
    }
    @Cacheable(value="BloodGroup",key="#bloodid")
    public BloodGroup getBloodDetail(int bloodid){
        log.info("its calling the database" );
        return  bloodGroupRepository.findById(bloodid).get();
    }
}
