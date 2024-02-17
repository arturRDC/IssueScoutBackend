package com.arturrdc.issuescoutbackend.project;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final
    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
