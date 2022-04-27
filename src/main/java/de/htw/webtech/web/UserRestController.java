package de.htw.webtech.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    private List<User> users;

    public UserRestController() {
        users =new ArrayList<>();
        users.add(new User(1, "Max", "max@web.de", "123"));
        users.add(new User(2, "Lilly", "lilly@web.de", "456"));
    }

    @GetMapping(path = "/api/user")
    public ResponseEntity<List<User>> fetchUsers(){
        return ResponseEntity.ok(users);
    }
}
