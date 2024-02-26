package com.arturrdc.issuescoutbackend;

import com.arturrdc.issuescoutbackend.project.Project;
import com.arturrdc.issuescoutbackend.project.ProjectRepository;
import com.arturrdc.issuescoutbackend.project.ProjectResponse;
import com.arturrdc.issuescoutbackend.project.ProjectService;
import com.arturrdc.issuescoutbackend.security.models.ERole;
import com.arturrdc.issuescoutbackend.security.models.Role;
import com.arturrdc.issuescoutbackend.security.repository.RoleRepository;
import com.arturrdc.issuescoutbackend.ticket.Ticket;
import com.arturrdc.issuescoutbackend.user.User;
import com.arturrdc.issuescoutbackend.user.UserRepository;
import com.arturrdc.issuescoutbackend.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class IssueScoutBackendApplication implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectService projectService;
    @Autowired
    PasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(IssueScoutBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(ERole.Developer));
        roleRepository.save(new Role(ERole.Admin));
        roleRepository.save(new Role(ERole.Manager));
        roleRepository.save(new Role(ERole.Submitter));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.Admin)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        User admin = new User("admin", "admin@email.com", passwordEncoder.encode("password"), "Admin", "", "01 Jan 24");
        admin.setRoles(roles);
        userRepository.save(admin);

        Date now = new Date();  // Replace this with your actual Date object
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        now = calendar.getTime();
        SimpleDateFormat dateFormatUp = new SimpleDateFormat("dd MMM yy HH:mm");
        SimpleDateFormat dateFormatCr = new SimpleDateFormat("dd MMM yy");
        String nowUp = dateFormatUp.format(now);
        String nowCr = dateFormatCr.format(now);

        projectService.createProject(new Project("ProjectA","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat.",admin, nowUp, nowCr, new ArrayList<User>(), new ArrayList<Ticket>()));
        projectService.createProject(new Project("ProjectB","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat.",admin, nowUp, nowCr, new ArrayList<User>(), new ArrayList<Ticket>()));
        projectService.createProject(new Project("ProjectC","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat.",admin, nowUp, nowCr, new ArrayList<User>(), new ArrayList<Ticket>()));

    }
}
