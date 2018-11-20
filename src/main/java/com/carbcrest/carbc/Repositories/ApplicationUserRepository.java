package com.carbcrest.carbc.Repositories;


import com.carbcrest.carbc.Security.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
