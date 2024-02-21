package com.arturrdc.issuescoutbackend.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    final
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @CrossOrigin(origins = "*")
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

        Project p1 = new Project("n1","desc","man", nowUp, nowCr);
        Project p2 = new Project("n2","desc","man", nowUp, nowCr);
        Project p3 = new Project("n3","desc","man", nowUp, nowCr);
        p1.setId(1L);
        p2.setId(2L);
        p3.setId(3L);
        List<Project> pItems = Arrays.asList(p1,p2,p3);
        Map<String, Object> response = new HashMap<>();
        response.put("data", pItems);
        return response;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{projectId}/addUser/{userId}")
    public String addUserToProject(@PathVariable Long projectId, @PathVariable Long userId) {
        System.out.println("user " + userId+ " added to project " + projectId);
//        projectService.addUserToProject(projectId, userId);
        return "User added to project successfully";
    }
    ///api/projects/${id}/changeRole/${userId}/${role}

    @CrossOrigin(origins = "*")
    @PostMapping("/{projectId}/changeRole/{userId}/{role}")
    public String addUserToProject(@PathVariable Long projectId, @PathVariable Long userId, @PathVariable String role) {
        System.out.println("user " + userId+ " in project " + projectId + " changed role to " + role);
//        projectService.changeUserRole(projectId, userId, role);
        return "User changed role successfully";
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id) {
        // ProjectService.deleteProject(id);
        System.out.println("project "+ id + " deleted");
        return new ResponseEntity<>("Project with ID " + id + " has been deleted.", HttpStatus.OK);
    }
}
