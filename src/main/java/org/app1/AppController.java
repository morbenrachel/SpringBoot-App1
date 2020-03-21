package org.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@ComponentScan(basePackages = {"org.app2.*"})
public class AppController {

    @Autowired
    private UserDataService userDataService;

    @GetMapping("/getUserById/{userId}")
    public String getUserById(@PathVariable UUID userId) {
        userDataService.getUserDetailsByUserId(userId);
        return "woohoo from AppController that got userId = " + userId;
    }

    @GetMapping("/getAllUsers/{sorted}")
    public String getUsers(@PathVariable Boolean sorted) {
        List<String> allUsers = userDataService.getAllUserNames(sorted);
        return "woohoo from getAllUsers that got sorted = " + sorted;
    }

    @PostMapping("/addUser")
    public String create(@RequestBody Map<String, String> body){
        int birthYear = Integer.parseInt(body.get("birthYear"));
        String name = body.get("name");
        String surname = body.get("surname");
        UUID newUserId = userDataService.addUser(name, surname, birthYear);
        return "woohoo added user with userId = " + newUserId;
    }

}