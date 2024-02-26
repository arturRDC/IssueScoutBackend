package com.arturrdc.issuescoutbackend.mapper;

import com.arturrdc.issuescoutbackend.project.Project;
import com.arturrdc.issuescoutbackend.project.ProjectResponse;
import com.arturrdc.issuescoutbackend.user.User;
import com.arturrdc.issuescoutbackend.user.UserListDTO;
import com.arturrdc.issuescoutbackend.user.UserSelectionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class MapperService {
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
}