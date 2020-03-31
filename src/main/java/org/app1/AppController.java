package org.app1;

import org.app2.User;
import org.app2.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
//@ComponentScan(basePackageClasses = {UserDataService.class})
public class AppController {


//  AppController
//    private org.app2.UserDataService userDataService;
    @Autowired
    private UserDataService userDataService;

    @GetMapping("/getUserById/{userId}")
    public String getUserById(@PathVariable(value = "userId") String userId) throws IOException{
        User userDetails = userDataService.getUserDetailsById(userId);
        return "woohoo from AppController that got userId = " + userDetails;
    }

    @GetMapping("/getAllUsers/{sorted}")
    public String getUsers(@PathVariable("sorted") Boolean sorted) throws IOException {
        List<User> allUsers = userDataService.getAllUserNames(sorted);
        return "woohoo from getAllUsers that got sorted = " + allUsers;
    }

    @PostMapping("/addUser")
    public String create(@RequestBody Map<String, String> body){
        int birthYear = Integer.parseInt(body.get("birthYear"));
        String name = body.get("name");
        String surname = body.get("surname");
        String newUserId = userDataService.addUser(name, surname, birthYear);
        return "woohoo added user with userId = " + newUserId;
    }

}