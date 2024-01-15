package com.jobportal.server.repository;

import com.jobportal.server.entity.Company;
import com.jobportal.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM company where username=:username and password=:password")
    Optional<Company> authenticate(@Param("username") String username, @Param("password") String password);
}
