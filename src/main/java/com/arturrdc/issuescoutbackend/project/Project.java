package com.arturrdc.issuescoutbackend.project;

import com.arturrdc.issuescoutbackend.ticket.Ticket;
import com.arturrdc.issuescoutbackend.user.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String desc;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;
    @Column(name = "updated_at")
    private String updatedAt;
    @Column(name="created_at")
    private String createdAt;

    @ManyToMany
    @JoinTable(
            name = "project_members",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;

    @OneToMany(mappedBy = "project")
    private List<Ticket> tickets;

    public Project(String name, String desc, User manager, String updatedAt, String createdAt, List<User> members, List<Ticket> tickets) {
        this.name = name;
        this.desc = desc;
        this.manager = manager;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.members = members;
        this.tickets = tickets;
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

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
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

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
