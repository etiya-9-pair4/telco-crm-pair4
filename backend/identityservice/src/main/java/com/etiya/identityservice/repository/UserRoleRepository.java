package com.etiya.identityservice.repository;

import com.etiya.identityservice.entity.Role;
import com.etiya.identityservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findById(Integer id);
}
