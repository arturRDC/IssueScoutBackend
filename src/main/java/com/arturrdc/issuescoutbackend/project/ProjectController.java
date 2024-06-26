package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.mapper.MapperService;
import com.arturrdc.issuescoutbackend.project.exception.UnauthorizedProjectEdit;
import com.arturrdc.issuescoutbackend.project.payload.request.EditProjectRequest;
import com.arturrdc.issuescoutbackend.project.payload.request.NewProjectRequest;
import com.arturrdc.issuescoutbackend.project.payload.response.ProjectResponse;
import com.arturrdc.issuescoutbackend.user.UserListDTO;
import com.arturrdc.issuescoutbackend.user.UserSelectionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
//@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600, allowCredentials = "true", exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    final
    ProjectService projectService;
    final
    MapperService mapperService;

    public ProjectController(ProjectService projectService, MapperService mapperService) {
        this.projectService = projectService;
        this.mapperService = mapperService;
    }



    @GetMapping("")
    public Map<String, Object> getProjects() {
        List<Project> projects = projectService.getAllProjects();


        List<ProjectResponse> pItems = mapperService.mapProjectsToResponses(projects);
        Map<String, Object> response = new HashMap<>();
        response.put("data", pItems);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<NewProjectRequest> addProject(@Validated @ModelAttribute NewProjectRequest newProjectRequest) {
        Project newProject = mapperService.mapNewProjectReqToProject(newProjectRequest);
        projectService.createProject(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProjectRequest);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EditProjectRequest> addProject(@PathVariable Long id, @Validated @ModelAttribute EditProjectRequest editProjectRequest) {
        projectService.updateProject(id, editProjectRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(editProjectRequest);
    }




    @PostMapping("/{projectId}/addUser/{userId}")
    public ResponseEntity<String> addUserToProject(@PathVariable Long projectId, @PathVariable Long userId) {
        System.out.println("user " + userId+ " added to project " + projectId);
        try {
            projectService.addUserToProject(projectId, userId);
        } catch (UnauthorizedProjectEdit e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unable to add user to project");
        }
        return ResponseEntity.status(HttpStatus.OK).body("User added to project");
    }


    @PostMapping("/{projectId}/changeRole/{userId}/{role}")
    public String changeRole(@PathVariable Long projectId, @PathVariable Long userId, @PathVariable String role) {
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
                new TicketProjectDTO(1L, "Fix login bug", "Bug", "High", "Medium", new UserSelectionDTO(1L,"John Doe"), "open", dateFormat.format(new Date())),
                new TicketProjectDTO(2L, "Add dark mode feature", "Feature", "Low", "High", new UserSelectionDTO(2L,"Jane Smith"), "in progress", dateFormat.format(new Date())),
                new TicketProjectDTO(3L, "User feedback on UI", "Comment", "Medium", "Low", new UserSelectionDTO(3L,"Alex Jones"), "closed", dateFormat.format(new Date())),
                new TicketProjectDTO(4L, "Request for API access", "Request", "High", "Medium", new UserSelectionDTO(4L,"Sam Wilson"), "open", dateFormat.format(new Date()))
        };

        Map<String, Object> response = new HashMap<>();
        response.put("data", tickets);
        return response;
    }


    @GetMapping("/{id}/users")
    public Map<String, Object> getTeamMembers(@PathVariable Long id) {
        Project project = projectService.getProjectById(id).get();
        List<UserListDTO> userListDTO = mapperService.mapUsersToDTOs(project.getMembers());

//        UserListDTO[] userListDTOS = new UserListDTO[] {
//                new UserListDTO("1","Alex", "https://reqres.in/img/faces/1-image.jpg", "alex@issuescout.com", "Developer", "19 May 2024", "5 hr ago"),
//                new UserListDTO("2","Ereena", "https://reqres.in/img/faces/2-image.jpg", "ereena@issuescout.com", "Developer", "18 May 2024", "15 min ago"),
//                new UserListDTO("3","John", "https://reqres.in/img/faces/3-image.jpg", "john@issuescout.com", "Developer", "17 May 2024", "20 hr ago"),
//                new UserListDTO("4","Matrix", "https://reqres.in/img/faces/4-image.jpg", "matrix@issuescout.com", "Manager", "16 May 2024", "1 hr ago"),
//                new UserListDTO("5","Virat", "https://reqres.in/img/faces/5-image.jpg", "virat@issuescout.com", "Submitter", "15 May 2024", "40 min ago"),
//                new UserListDTO("6","Miya", "https://reqres.in/img/faces/6-image.jpg", "miya@issuescout.com", "Submitter", "13 May 2024", "5 hr ago")
//        };
        Map<String, Object> response = new HashMap<>();
        response.put("data", userListDTO);
        return response;
    }


}
