package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.project.exception.UnauthorizedProjectEdit;
import com.arturrdc.issuescoutbackend.project.payload.request.EditProjectRequest;
import com.arturrdc.issuescoutbackend.security.models.ERole;
import com.arturrdc.issuescoutbackend.security.models.Role;
import com.arturrdc.issuescoutbackend.user.User;
import com.arturrdc.issuescoutbackend.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    final
    UserService userService;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, EditProjectRequest editProjectRequest) {
        Project project = projectRepository.findById(id).get();

        project.setName(editProjectRequest.getName());
        project.setDesc(editProjectRequest.getDesc());
        project = setUpdatedAt(project);
        projectRepository.save(project);

        return project;
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project setUpdatedAt(Project project) {
        Date unformattedNow = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yy HH:mm");
        String now = df.format(unformattedNow);
        project.setUpdatedAt(now);
        return project;
    }

    public void addUserToProject(Long projectId, Long userId) throws UnauthorizedProjectEdit{
        Set<Role> roles = userService.getLoggedInUser().getRoles();
        boolean authorized = false;
        for (Role role : roles) {
            if ((role.getName() == ERole.Manager) || (role.getName() == ERole.Admin)) {
                authorized = true;
            }
        }
        if (!authorized) {
            throw new UnauthorizedProjectEdit("Unable to add user to project");
        }
        Project project = projectRepository.findById(projectId).get();

        List<User> members = project.getMembers();

        for (User member : members) {
            if (Objects.equals(member.getId(), userId)) {
                throw new UnauthorizedProjectEdit("User is already in project");
            }
        }

        members.add(userService.getUser(userId).get());
        project.setMembers(members);
        projectRepository.save(project);
    }
}
