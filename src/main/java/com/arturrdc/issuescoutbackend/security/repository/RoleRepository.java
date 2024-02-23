package com.arturrdc.issuescoutbackend.security.repository;

import com.arturrdc.issuescoutbackend.security.models.ERole;
import com.arturrdc.issuescoutbackend.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
