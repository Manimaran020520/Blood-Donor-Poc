package com.example.BloodDonor.Repository;

import com.example.BloodDonor.Entity.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodGroupRepository extends JpaRepository<BloodGroup,Integer> {
    @Query(value = "Select bloodid from BloodGroup where bloodgroup=?1")
    int findByBloodgroup(String bloodgroup);
    @Query(value="Select b from BloodGroup b where b.bloodgroup=?1")
    BloodGroup findBloodGroup(String bloodgroup);
}
