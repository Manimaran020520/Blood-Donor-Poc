package com.app.Entity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Donors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface donorRepository extends JpaRepository<Donors,Integer> {

	@Query(value = "select d from Donors d where d.address.address_id=?1 and d.bloodGroup.bloodgroup_id=?2")
    Donors findByAddressAndBloodGroup(int address,int bloodGroup);
//Donors findByemailid(String emailid);
	
//List<Donors> findByCountryCode(String countryCode);
}
