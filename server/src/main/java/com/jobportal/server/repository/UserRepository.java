package com.jobportal.server.repository;

import com.jobportal.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM users where email=:email and password=:password")
    Optional<User> authenticate(@Param("email") String email, @Param("password") String password);
}
