package com.app.Entity.Repository;

import com.app.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface addressRepository extends JpaRepository<Address,Integer> {
    List<Address> findByCountry(String country);
    List<Address> findByState(String state);
    List<Address> findByDistrict(String district);

    Address findByCountryAndStateAndDistrictAndCity (String country,String state,String district,String city );

    }
