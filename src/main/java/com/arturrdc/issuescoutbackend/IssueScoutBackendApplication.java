package com.arturrdc.issuescoutbackend;

import com.arturrdc.issuescoutbackend.security.models.ERole;
import com.arturrdc.issuescoutbackend.security.models.Role;
import com.arturrdc.issuescoutbackend.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IssueScoutBackendApplication implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;
    public static void main(String[] args) {
        SpringApplication.run(IssueScoutBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(ERole.ROLE_DEVELOPER));
        roleRepository.save(new Role(ERole.ROLE_ADMIN));
        roleRepository.save(new Role(ERole.ROLE_MANAGER));
        roleRepository.save(new Role(ERole.ROLE_SUBMITTER));
    }
}
