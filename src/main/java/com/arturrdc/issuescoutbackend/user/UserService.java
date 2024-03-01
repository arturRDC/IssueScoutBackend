package com.arturrdc.issuescoutbackend.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
    @Value("${issueScout.app.baseUrl}")
    private String baseUrl;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> optLoggedInUser = userRepository.findByUsername(username);
        return optLoggedInUser.get();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
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
        User loggedInUser = getLoggedInUser();
        
        loggedInUser.setName(userUpdateRequest.getName());
        loggedInUser.setEmail(userUpdateRequest.getEmail());
        if (userUpdateRequest.getPassword() != null && !userUpdateRequest.getPassword().isEmpty()) {
            loggedInUser.setPassword(hashPassword(userUpdateRequest.getPassword()));
        }
        if (userUpdateRequest.getProfilePicture() != null && !userUpdateRequest.getProfilePicture().isEmpty()) {
            String profilePicturePath = null;
            try {
                profilePicturePath = saveProfilePicture(userUpdateRequest.getProfilePicture());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            loggedInUser.setProfilePicture(profilePicturePath);
        }

        userRepository.save(loggedInUser);
    }

    private String hashPassword(String password) {
        return encoder.encode(password);
    }

    private String saveProfilePicture(MultipartFile profilePicture) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(profilePicture.getOriginalFilename()));
        String basePath = Paths.get("").toAbsolutePath() + "/files/avatars/";

        // Create the directory if it doesn't exist
        File directory = new File(basePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = basePath + fileName;
        File file = new File(filePath);

        // Copy the file to the destination
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            FileCopyUtils.copy(profilePicture.getInputStream(), outputStream);
        }

        // Return the URL of the saved file
        return baseUrl + "/files/avatars/" + fileName;
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
