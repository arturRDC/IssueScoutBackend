package com.arturrdc.issuescoutbackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class UserController {
    final
    UserService userService;
    final
    UserMapperService userMapperService;

    public UserController(UserService userService, UserMapperService userMapperService) {
        this.userService = userService;
        this.userMapperService = userMapperService;
    }
//    private static final String[] TEAM_MEMBERS = {
//        "Alex,https://reqres.in/img/faces/1-image.jpg,alex@dashwind.com,Developer,19 May 2024,5 hr ago",
//                "Ereena,https://reqres.in/img/faces/2-image.jpg,ereena@dashwind.com,Developer,18 May 2024,15 min ago",
//                "John,https://reqres.in/img/faces/3-image.jpg,john@dashwind.com,Developer,17 May 2024,20 hr ago",
//                "Matrix,https://reqres.in/img/faces/4-image.jpg,matrix@dashwind.com,Manager,16 May 2024,1 hr ago",
//                "Virat,https://reqres.in/img/faces/5-image.jpg,virat@dashwind.com,Submitter,15 May 2024,40 min ago",
//                "Miya,https://reqres.in/img/faces/6-image.jpg,miya@dashwind.com,Submitter,13 May 2024,5 hr ago"
//    };


    @GetMapping("names")
    Map<String, Object> getUserNames() {



        UserSelectionDTO u1 = new UserSelectionDTO(1L,"Artur");
        UserSelectionDTO u2 = new UserSelectionDTO(2L,"Barbara");
        UserSelectionDTO u3 = new UserSelectionDTO(3L,"Carlos");
        List<UserSelectionDTO> uItems = userService.getUsersSelection();
        Map<String, Object> response = new HashMap<>();
        response.put("data", new UserSelectionDTO[]{u1,u2,u3});
        return response;
    }



    @GetMapping("")
    public Map<String, Object> getUsers() {
//        UserListDTO[] userListDTOS = new UserListDTO[] {
//                new UserListDTO("1","Alex", "https://reqres.in/img/faces/1-image.jpg", "alex@dashwind.com", "Developer", "19 May 24", "19 May 24"),
//                new UserListDTO("2","Ereena", "https://reqres.in/img/faces/2-image.jpg", "ereena@dashwind.com", "Developer", "18 May 24", "15 min ago"),
//                new UserListDTO("3","John", "https://reqres.in/img/faces/3-image.jpg", "john@dashwind.com", "Developer", "17 May 24", "20 hr ago"),
//                new UserListDTO("4","Matrix", "https://reqres.in/img/faces/4-image.jpg", "matrix@dashwind.com", "Manager", "16 May 24", "1 hr ago"),
//                new UserListDTO("5","Virat", "https://reqres.in/img/faces/5-image.jpg", "virat@dashwind.com", "Submitter", "15 May 24", "40 min ago"),
//                new UserListDTO("6","Miya", "https://reqres.in/img/faces/6-image.jpg", "miya@dashwind.com", "Submitter", "13 May 24", "5 hr ago")
//        };
        List<UserListDTO> userListDTOS = userMapperService.mapUsersToDTOs((userService.getUsers()));
        Map<String, Object> response = new HashMap<>();
        response.put("data", userListDTOS);
        return response;
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> updateUser(
            @Validated @ModelAttribute UserUpdateRequest userUpdateRequest) {
        userService.updateUser(userUpdateRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
