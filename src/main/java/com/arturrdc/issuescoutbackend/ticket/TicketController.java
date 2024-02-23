package com.arturrdc.issuescoutbackend.ticket;

import com.arturrdc.issuescoutbackend.project.Project;
import com.arturrdc.issuescoutbackend.project.ProjectService;
import com.arturrdc.issuescoutbackend.ticket.TicketDTO;
import com.arturrdc.issuescoutbackend.user.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    final
    ProjectService projectService;

    public TicketController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable Long id) {

        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png", "Bug", "Jane Smith", "Open", "21 May 24","21 May 24 14:59");

        return ticket;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/{id}")
    public TicketDTO editTicket(@PathVariable Long id) {

        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png", "Bug", "Jane Smith", "Open","21 May 24","21 May 24 14:59");

        return ticket;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {

//        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png", "Bug");
        System.out.println("deleted ticket with id " + id);
    }




}
