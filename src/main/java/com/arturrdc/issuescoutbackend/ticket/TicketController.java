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

        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png");

        return ticket;
//        Date now = new Date();  // Replace this with your actual Date object
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        calendar.add(Calendar.DAY_OF_YEAR, -1);
//
//        now = calendar.getTime();
//        SimpleDateFormat dateFormatUp = new SimpleDateFormat("dd MMM yy HH:mm");
//        SimpleDateFormat dateFormatCr = new SimpleDateFormat("dd MMM yy");
//        String nowUp = dateFormatUp.format(now);
//        String nowCr = dateFormatCr.format(now);
//
//        Project p1 = new Project("ProjectA","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat. Integer nisi leo, feugiat id justo id, commodo ultricies sem. Nullam malesuada elementum justo at vehicula. Vivamus laoreet libero vitae augue porttitor interdum.","man", nowUp, nowCr);
//        Project p2 = new Project("ProjectB","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat. Integer nisi leo, feugiat id justo id, commodo ultricies sem. Nullam malesuada elementum justo at vehicula. Vivamus laoreet libero vitae augue porttitor interdum.","man", nowUp, nowCr);
//        Project p3 = new Project("ProjectC","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat. Integer nisi leo, feugiat id justo id, commodo ultricies sem. Nullam malesuada elementum justo at vehicula. Vivamus laoreet libero vitae augue porttitor interdum.","man", nowUp, nowCr);
//        p1.setId(1L);
//        p2.setId(2L);
//        p3.setId(3L);
//        List<Project> pItems = Arrays.asList(p1,p2,p3);
//        Map<String, Object> response = new HashMap<>();
//        response.put("data", pItems);
//        return response;
    }




}
