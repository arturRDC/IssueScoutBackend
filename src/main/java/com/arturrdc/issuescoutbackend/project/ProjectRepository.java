package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
