package com.arturrdc.issuescoutbackend.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserMapperService {
    public UserListDTO mapUserToDTO(User user) {
        return new UserListDTO(
                user.getId().toString(),
                user.getName(),
                user.getProfilePicture(),
                user.getEmail(),
                new ArrayList<>(user.getRoles()).toString(),
                user.getJoinedOn(),
                user.getLastActive()
        );
    }

    public List<UserListDTO> mapUsersToDTOs(List<User> users) {
        return users.stream()
                .map(this::mapUserToDTO)
                .collect(Collectors.toList());
    }
}