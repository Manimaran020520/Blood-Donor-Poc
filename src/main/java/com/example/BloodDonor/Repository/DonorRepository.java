package com.example.BloodDonor.Repository;

import com.example.BloodDonor.Entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository  extends JpaRepository<Donor,Integer> {
    @Query(value = "SELECT d FROM Donor as d WHERE d.address.addressid=?1 " )
    List<Donor> findByAddress(int addressid);

    @Query(value="Select d from Donor as d where d.bloodGroup.bloodid=?1")
    List<Donor> findByBloodGroup(int bloodid);
    @Query(value = "Select d from Donor as d where d.address.addressid=?1 and d.bloodGroup.bloodid=?2")
    List<Donor> findByAddressAndBloodGroup(int address,int bloodGroup);
    Boolean existsByMobileNumber(long mobilenumber);
}
