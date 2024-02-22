package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.user.UserDTO;

public class TicketDTO {
    public Long id;
    public String title;
    public String type;
    public String priority;
    public String difficulty;
    public UserDTO assignedTo;
    public String status;
    public String updatedAt;

    public TicketDTO(Long id, String title, String type, String priority, String difficulty, UserDTO assignedTo, String status, String updatedAt) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.priority = priority;
        this.difficulty = difficulty;
        this.assignedTo = assignedTo;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public TicketDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public UserDTO getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserDTO assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
