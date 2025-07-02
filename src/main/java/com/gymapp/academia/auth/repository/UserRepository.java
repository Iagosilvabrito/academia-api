package com.gymapp.academia.auth.repository;

import com.gymapp.academia.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByname(String name);
    Optional<User> findByUser(String name);

}
