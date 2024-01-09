package com.app.Entity.Repository;

import com.app.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface loginRepository extends JpaRepository<Login,String> {

}
