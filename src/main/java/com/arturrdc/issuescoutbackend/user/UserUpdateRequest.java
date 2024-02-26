package com.arturrdc.issuescoutbackend.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

public class UserUpdateRequest {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String password;

    private MultipartFile profilePicture;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }
}
