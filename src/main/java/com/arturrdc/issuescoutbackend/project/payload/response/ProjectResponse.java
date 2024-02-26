package com.arturrdc.issuescoutbackend.project.payload.response;

import com.arturrdc.issuescoutbackend.ticket.Ticket;
import com.arturrdc.issuescoutbackend.user.User;
import com.arturrdc.issuescoutbackend.user.UserSelectionDTO;
import jakarta.persistence.*;

import java.util.List;

public class ProjectResponse {

    private String id;

    private String name;

    private String desc;

    private String manager;

    private String updatedAt;

    private String createdAt;


    public ProjectResponse(String id, String name, String desc, String manager, String updatedAt, String createdAt) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.manager = manager;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;

    }

    public ProjectResponse() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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
