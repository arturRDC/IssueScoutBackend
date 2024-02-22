package com.arturrdc.issuescoutbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    private static final String[] TEAM_MEMBERS = {
//        "Alex,https://reqres.in/img/faces/1-image.jpg,alex@dashwind.com,Developer,19 May 2024,5 hr ago",
//                "Ereena,https://reqres.in/img/faces/2-image.jpg,ereena@dashwind.com,Developer,18 May 2024,15 min ago",
//                "John,https://reqres.in/img/faces/3-image.jpg,john@dashwind.com,Developer,17 May 2024,20 hr ago",
//                "Matrix,https://reqres.in/img/faces/4-image.jpg,matrix@dashwind.com,Manager,16 May 2024,1 hr ago",
//                "Virat,https://reqres.in/img/faces/5-image.jpg,virat@dashwind.com,Submitter,15 May 2024,40 min ago",
//                "Miya,https://reqres.in/img/faces/6-image.jpg,miya@dashwind.com,Submitter,13 May 2024,5 hr ago"
//    };

    @CrossOrigin(origins = "*")
    @GetMapping("names")
    Map<String, Object> getUserNames() {



        User u1 = new User("Artur");
        User u2 = new User("Barbara");
        User u3 = new User("Carlos");
        u1.setId(1L);
        u2.setId(2L);
        u3.setId(3L);
        userService.saveUser(u1);
        userService.saveUser(u2);
        userService.saveUser(u3);
        List<UserDTO> uItems = userService.getUsers();
        Map<String, Object> response = new HashMap<>();
        response.put("data", uItems);
        return response;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("")
    public Map<String, Object> getTeamMembers() {
        TeamMember[] teamMembers = new TeamMember[] {
                new TeamMember("1","Alex", "https://reqres.in/img/faces/1-image.jpg", "alex@dashwind.com", "Developer", "19 May 2024", "5 hr ago"),
                new TeamMember("2","Ereena", "https://reqres.in/img/faces/2-image.jpg", "ereena@dashwind.com", "Developer", "18 May 2024", "15 min ago"),
                new TeamMember("3","John", "https://reqres.in/img/faces/3-image.jpg", "john@dashwind.com", "Developer", "17 May 2024", "20 hr ago"),
                new TeamMember("4","Matrix", "https://reqres.in/img/faces/4-image.jpg", "matrix@dashwind.com", "Manager", "16 May 2024", "1 hr ago"),
                new TeamMember("5","Virat", "https://reqres.in/img/faces/5-image.jpg", "virat@dashwind.com", "Submitter", "15 May 2024", "40 min ago"),
                new TeamMember("6","Miya", "https://reqres.in/img/faces/6-image.jpg", "miya@dashwind.com", "Submitter", "13 May 2024", "5 hr ago")
        };
        Map<String, Object> response = new HashMap<>();
        response.put("data", teamMembers);
        return response;
    }
}
