package com.example.BloodDonor.Repository;

import com.example.BloodDonor.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "select distinct a.country from Address a")
    List<String> findcountries();
    @Query(value="select distinct a.state from Address a where a.country=?1")
    List<String> findByCountry(String country);
    @Query(value="select  distinct a.district from Address a where a.state=?1")
    List<String> findByState(String state);
    @Query(value="select   a.city from Address a  where district=?1")
    List<String> findByDistrict(String district);
    List<Address> findByCountryAndState(String country,String state);
    @Query(value="select a.city from Address a where a.country=?1 and a.state=?2 and a.district=?3")
    List<String> findByCountryAndStateAndDistrict(String country,String state,String district);
    Address findByCity(String city);
    Boolean existsByCity(String city);
    Boolean existsByDistrict(String district);
    Boolean existsByState(String state);
    Boolean existsByCountry(String country);

    Address findByCountryAndStateAndDistrictAndCity(String country,String state,String district,String city);

}
