package com.arturrdc.issuescoutbackend.user;

import com.arturrdc.issuescoutbackend.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.name FROM User u")
    List<String> listAllNames();
}
