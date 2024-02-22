package com.arturrdc.issuescoutbackend.ticket;

import com.arturrdc.issuescoutbackend.user.UserDTO;

public class TicketDTO {
    private Long id;
    private String title;
    private String desc;
    private UserDTO assignedTo;
    private String priority;
    private String difficulty;
    private String attachment;

    public TicketDTO(Long id, String title, String desc, UserDTO assignedTo, String priority, String difficulty, String attachment) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.difficulty = difficulty;
        this.attachment = attachment;
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

    public UserDTO getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserDTO assignedTo) {
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
