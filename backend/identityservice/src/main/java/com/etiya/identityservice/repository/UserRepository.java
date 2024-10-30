package com.etiya.identityservice.repository;

import com.etiya.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    static List<User> getAll() {
        return null;
    }
    Optional<User> findByEmailIgnoreCase(String email);
}
