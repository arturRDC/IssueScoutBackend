package com.arturrdc.issuescoutbackend.mapper;

import com.arturrdc.issuescoutbackend.project.ProjectService;
import com.arturrdc.issuescoutbackend.project.payload.request.EditProjectRequest;
import com.arturrdc.issuescoutbackend.project.payload.request.NewProjectRequest;
import com.arturrdc.issuescoutbackend.project.Project;
import com.arturrdc.issuescoutbackend.project.payload.response.ProjectResponse;
import com.arturrdc.issuescoutbackend.ticket.Ticket;
import com.arturrdc.issuescoutbackend.user.User;
import com.arturrdc.issuescoutbackend.user.UserListDTO;
import com.arturrdc.issuescoutbackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class MapperService {
    final
    UserService userService;
    final
    ProjectService projectService;

    public MapperService(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    public UserListDTO mapUserToDTO(User user) {
        return new UserListDTO(
                user.getId().toString(),
                user.getName(),
                user.getProfilePicture(),
                user.getEmail(),
                new ArrayList<>(user.getRoles()).toString(),
                user.getJoinedOn(),
                user.getLastActive()
        );
    }

    public List<UserListDTO> mapUsersToDTOs(List<User> users) {
        return users.stream()
                .map(this::mapUserToDTO)
                .collect(Collectors.toList());
    }
    public ProjectResponse mapProjectToResponse(Project project) {
        return new ProjectResponse(
                project.getId().toString(),
                project.getName(),
                project.getDesc(),
                project.getManager().getName(),
                project.getUpdatedAt(),
                project.getCreatedAt()
        );
    }

    public List<ProjectResponse> mapProjectsToResponses(List<Project> projects) {
        return projects.stream()
                .map(this::mapProjectToResponse)
                .collect(Collectors.toList());
    }

    public Project mapNewProjectReqToProject(NewProjectRequest newProjectRequest) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);

        now = calendar.getTime();
        SimpleDateFormat dateFormatUp = new SimpleDateFormat("dd MMM yy HH:mm");
        SimpleDateFormat dateFormatCr = new SimpleDateFormat("dd MMM yy");
        String nowUp = dateFormatUp.format(now);
        String nowCr = dateFormatCr.format(now);
        return new Project(
                newProjectRequest.getName(),
                newProjectRequest.getDesc(),
                userService.getLoggedInUser(),
                nowUp,
                nowCr,
                new ArrayList<User>(),
                new ArrayList<Ticket>()
        );
    }

}