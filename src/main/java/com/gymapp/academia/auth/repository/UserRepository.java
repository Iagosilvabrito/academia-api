package com.gymapp.academia.auth.repository;

import com.gymapp.academia.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String name);
    Optional<User> findByUsername(String name);

}
