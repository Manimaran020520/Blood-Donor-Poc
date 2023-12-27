package com.app.Entity.Repository;

import com.app.Entity.Bloodgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bloodGroupRepository extends JpaRepository <Bloodgroup,Integer> {
Bloodgroup findByBloodgroup(String bloodgroup);
}
