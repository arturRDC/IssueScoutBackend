package com.arturrdc.issuescoutbackend.user;

public class TeamMember {
    private String id;
    private String name;
    private String avatar;
    private String email;
    private String role;
    private String joinedOn;
    private String lastActive;

    public TeamMember(String id, String name, String avatar, String email, String role, String joinedOn, String lastActive) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.email = email;
        this.role = role;
        this.joinedOn = joinedOn;
        this.lastActive = lastActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getJoinedOn() {
        return joinedOn;
    }

    public String getLastActive() {
        return lastActive;
    }
}
