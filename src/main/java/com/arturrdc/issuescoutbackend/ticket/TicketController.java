package com.arturrdc.issuescoutbackend.ticket;

import com.arturrdc.issuescoutbackend.project.ProjectService;
import com.arturrdc.issuescoutbackend.project.TicketProjectDTO;
import com.arturrdc.issuescoutbackend.user.UserSelectionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    final
    ProjectService projectService;

    public TicketController(ProjectService projectService) {
        this.projectService = projectService;
    }



    @GetMapping("/{id}")
    public Map<String, Object> getTicket(@PathVariable Long id) {

        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserSelectionDTO(1L, "John Doe"), "High", "Medium", "Bug", "Jane Smith", "Open", "21 May 24","21 May 24 14:59");
        AttachmentDTO[] attachments = {new AttachmentDTO(1L, "image.png", "/static/images/image.png"), new AttachmentDTO(2L, "image2.png", "/static/images/image2.png")};
        HistoryDTO[] history = {new HistoryDTO("22 May 24 11:55","description", "desc1","desc2"), new HistoryDTO("23 May 24 11:55","title", "Fix login","Fix login bug")};
        Map<String, Object> response = new HashMap<>();
        response.put("details", ticket);
        response.put("comments", new CommentDTO[]{new CommentDTO("comment1", "John Doe", "21 May 24 16:59"), new CommentDTO("comment2", "Jane Smith", "21 May 24 17:10") });
        response.put("attachments", attachments);
        response.put("history", history);
        return response;
    }

    @PostMapping("/{id}")
    public TicketDTO editTicket(@PathVariable Long id) {

        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserSelectionDTO(1L, "John Doe"), "High", "Medium", "Bug", "Jane Smith", "Open","21 May 24","21 May 24 14:59");

        return ticket;
    }


    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {

//        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png", "Bug");
        System.out.println("deleted ticket with id " + id);
    }


    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDTO> addComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {

//        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png", "Bug", "Jane Smith", "Open","21 May 24","21 May 24 14:59");
        System.out.println("Added a new comment in project " + id);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDTO);
    }

    @DeleteMapping("/{id}/attachments/{attId}")
    public ResponseEntity<String> getAttachments(@PathVariable Long id, @PathVariable Long attId) {

//        TicketDTO ticket = new TicketDTO(1L, "Fix login bug", "Username escape characters", new UserDTO(1L, "John Doe"), "High", "Medium", "example.png", "Bug", "Jane Smith", "Open","21 May 24","21 May 24 14:59");
        System.out.println("attachment " + attId + " in project " + id + " deleted");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }


    @GetMapping("")
    public Map<String, Object> getTickets() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy HH:mm");

        TicketProjectDTO[] tickets = new TicketProjectDTO[]{
                new TicketProjectDTO(1L, "Fix login bug", "Bug", "High", "Medium", new UserSelectionDTO(1L,"John Doe"), "open", dateFormat.format(new Date())),
                new TicketProjectDTO(2L, "Add dark mode feature", "Feature", "Low", "High", new UserSelectionDTO(2L,"Jane Smith"), "in progress", dateFormat.format(new Date())),
                new TicketProjectDTO(3L, "User feedback on UI", "Comment", "Medium", "Low", new UserSelectionDTO(3L,"Alex Jones"), "closed", dateFormat.format(new Date())),
                new TicketProjectDTO(4L, "Request for API access", "Request", "High", "Medium", new UserSelectionDTO(4L,"Sam Wilson"), "open", dateFormat.format(new Date()))
        };

        Map<String, Object> response = new HashMap<>();
        response.put("data", tickets);
        return response;
    }






}
