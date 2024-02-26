package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.project.payload.request.EditProjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
}
