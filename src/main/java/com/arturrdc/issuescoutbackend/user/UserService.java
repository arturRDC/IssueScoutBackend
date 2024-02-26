package com.arturrdc.issuescoutbackend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public List<UserSelectionDTO> getUsersSelection() {
        return userRepository.findAll().stream()
                .map(user -> new UserSelectionDTO(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }
    List<String> getUserNames() {
        return userRepository.listAllNames();
    }
    void saveUser(User user) {userRepository.save(user);}

    public void updateUser(UserUpdateRequest userUpdateRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return;
        }
        String username = authentication.getName();
        Optional<User> optLoggedInUser = userRepository.findByUsername(username);
        User loggedInUser = optLoggedInUser.get();
        
        loggedInUser.setName(userUpdateRequest.getName());
        loggedInUser.setEmail(userUpdateRequest.getEmail());
        if (userUpdateRequest.getPassword() != null && !userUpdateRequest.getPassword().isEmpty()) {
            loggedInUser.setPassword(hashPassword(userUpdateRequest.getPassword()));
        }
        if (userUpdateRequest.getProfilePicture() != null && !userUpdateRequest.getProfilePicture().isEmpty()) {
            String profilePicturePath = saveProfilePicture(userUpdateRequest.getProfilePicture());
            loggedInUser.setProfilePicture(profilePicturePath);
        }

        userRepository.save(loggedInUser);
    }

    private String hashPassword(String password) {
        return encoder.encode(password);
    }

    private String saveProfilePicture(MultipartFile profilePicture) {
        // Implement file saving logic
        return "/avatars/1-image.jpg";
    }

    public void setLastActive(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        Date unformattedNow = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd MMM yy HH:mm");
        String now = df.format(unformattedNow);
        User user = userOptional.get();
        user.setLastActive(now);
        userRepository.save(user);
    }
}
