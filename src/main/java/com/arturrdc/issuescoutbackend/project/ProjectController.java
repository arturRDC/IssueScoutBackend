package com.arturrdc.issuescoutbackend.project;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/")
public class ProjectController {
    @CrossOrigin(origins = "*")
    @GetMapping("projects")
    Map<String, Object> getProjects() {
        Date now = new Date();  // Replace this with your actual Date object
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, -1);

        now = calendar.getTime();
        SimpleDateFormat dateFormatUp = new SimpleDateFormat("dd MMM yy HH:mm");
        SimpleDateFormat dateFormatCr = new SimpleDateFormat("dd MMM yy");
        String nowUp = dateFormatUp.format(now);
        String nowCr = dateFormatCr.format(now);

        Project p1 = new Project("n1","desc","man", nowUp, nowCr);
        Project p2 = new Project("n2","desc","man", nowUp, nowCr);
        Project p3 = new Project("n3","desc","man", nowUp, nowCr);
        p1.setId(1L);
        p2.setId(2L);
        p3.setId(3L);
        List<Project> pItems = Arrays.asList(p1,p2,p3);
        Map<String, Object> response = new HashMap<>();
        response.put("data", pItems);
        return response;
    }
}
