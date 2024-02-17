package com.arturrdc.issuescoutbackend.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Project {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private String desc;
    @Column
    private String manager;
    @Column
    private String updatedAt;
    @Column
    private String createdAt;

    public Project(String name, String desc, String manager, String updatedAt, String createdAt) {
        this.name = name;
        this.desc = desc;
        this.manager = manager;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Project() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
