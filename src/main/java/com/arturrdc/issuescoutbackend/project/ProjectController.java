package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.user.TeamMember;
import com.arturrdc.issuescoutbackend.user.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
//@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600, allowCredentials = "true", exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    final
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }



    @GetMapping("")
    public Map<String, Object> getProjects() {
        Date now = new Date();  // Replace this with your actual Date object
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        now = calendar.getTime();
        SimpleDateFormat dateFormatUp = new SimpleDateFormat("dd MMM yy HH:mm");
        SimpleDateFormat dateFormatCr = new SimpleDateFormat("dd MMM yy");
        String nowUp = dateFormatUp.format(now);
        String nowCr = dateFormatCr.format(now);

        Project p1 = new Project("ProjectA","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat. Integer nisi leo, feugiat id justo id, commodo ultricies sem. Nullam malesuada elementum justo at vehicula. Vivamus laoreet libero vitae augue porttitor interdum.","man", nowUp, nowCr);
        Project p2 = new Project("ProjectB","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat. Integer nisi leo, feugiat id justo id, commodo ultricies sem. Nullam malesuada elementum justo at vehicula. Vivamus laoreet libero vitae augue porttitor interdum.","man", nowUp, nowCr);
        Project p3 = new Project("ProjectC","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam justo erat, feugiat sed commodo nec, varius non risus. Integer aliquet ac risus sit amet volutpat. Integer nisi leo, feugiat id justo id, commodo ultricies sem. Nullam malesuada elementum justo at vehicula. Vivamus laoreet libero vitae augue porttitor interdum.","man", nowUp, nowCr);
        p1.setId(1L);
        p2.setId(2L);
        p3.setId(3L);
        List<Project> pItems = Arrays.asList(p1,p2,p3);
        Map<String, Object> response = new HashMap<>();
        response.put("data", pItems);
        return response;
    }


    @PostMapping("/{projectId}/addUser/{userId}")
    public String addUserToProject(@PathVariable Long projectId, @PathVariable Long userId) {
        System.out.println("user " + userId+ " added to project " + projectId);
//        projectService.addUserToProject(projectId, userId);
        return "User added to project successfully";
    }
    ///api/projects/${id}/changeRole/${userId}/${role}


    @PostMapping("/{projectId}/changeRole/{userId}/{role}")
    public String addUserToProject(@PathVariable Long projectId, @PathVariable Long userId, @PathVariable String role) {
        System.out.println("user " + userId+ " in project " + projectId + " changed role to " + role);
//        projectService.changeUserRole(projectId, userId, role);
        return "User changed role successfully";
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id) {
        // ProjectService.deleteProject(id);
        System.out.println("project "+ id + " deleted");
        return new ResponseEntity<>("Project with ID " + id + " has been deleted.", HttpStatus.OK);
    }


    @PostMapping("/{projectId}/addTicket")
    public ResponseEntity<String> addTicketToProject(@PathVariable Long projectId) {
        System.out.println("ticket added to project " + projectId);
        return ResponseEntity.ok("");
    }


    @GetMapping("/{projectId}/tickets")
    public Map<String, Object> getProjectTickets(@PathVariable Long projectId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy HH:mm");

        TicketProjectDTO[] tickets = new TicketProjectDTO[]{
                new TicketProjectDTO(1L, "Fix login bug", "Bug", "High", "Medium", new UserDTO(1L,"John Doe"), "open", dateFormat.format(new Date())),
                new TicketProjectDTO(2L, "Add dark mode feature", "Feature", "Low", "High", new UserDTO(2L,"Jane Smith"), "in progress", dateFormat.format(new Date())),
                new TicketProjectDTO(3L, "User feedback on UI", "Comment", "Medium", "Low", new UserDTO(3L,"Alex Jones"), "closed", dateFormat.format(new Date())),
                new TicketProjectDTO(4L, "Request for API access", "Request", "High", "Medium", new UserDTO(4L,"Sam Wilson"), "open", dateFormat.format(new Date()))
        };

        Map<String, Object> response = new HashMap<>();
        response.put("data", tickets);
        return response;
    }


    @GetMapping("/{id}/users")
    public Map<String, Object> getTeamMembers() {
        TeamMember[] teamMembers = new TeamMember[] {
                new TeamMember("1","Alex", "https://reqres.in/img/faces/1-image.jpg", "alex@dashwind.com", "Developer", "19 May 2024", "5 hr ago"),
                new TeamMember("2","Ereena", "https://reqres.in/img/faces/2-image.jpg", "ereena@dashwind.com", "Developer", "18 May 2024", "15 min ago"),
                new TeamMember("3","John", "https://reqres.in/img/faces/3-image.jpg", "john@dashwind.com", "Developer", "17 May 2024", "20 hr ago"),
                new TeamMember("4","Matrix", "https://reqres.in/img/faces/4-image.jpg", "matrix@dashwind.com", "Manager", "16 May 2024", "1 hr ago"),
                new TeamMember("5","Virat", "https://reqres.in/img/faces/5-image.jpg", "virat@dashwind.com", "Submitter", "15 May 2024", "40 min ago"),
                new TeamMember("6","Miya", "https://reqres.in/img/faces/6-image.jpg", "miya@dashwind.com", "Submitter", "13 May 2024", "5 hr ago")
        };
        Map<String, Object> response = new HashMap<>();
        response.put("data", teamMembers);
        return response;
    }


}
