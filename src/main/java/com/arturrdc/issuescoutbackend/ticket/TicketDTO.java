package com.arturrdc.issuescoutbackend.ticket;

import com.arturrdc.issuescoutbackend.user.UserSelectionDTO;

public class TicketDTO {
    private Long id;
    private String title;
    private String desc;
    private UserSelectionDTO assignedTo;
    private String priority;
    private String difficulty;
    private String type;
    private String submittedBy;
    private String status;
    private String createdAt;
    private String updatedAt;

    public TicketDTO(Long id, String title, String desc, UserSelectionDTO assignedTo, String priority, String difficulty, String type, String submittedBy, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.difficulty = difficulty;
        this.type = type;
        this.submittedBy = submittedBy;
        this.status = status;
        this.createdAt = createdAt;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public UserSelectionDTO getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserSelectionDTO assignedTo) {
        this.assignedTo = assignedTo;
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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
