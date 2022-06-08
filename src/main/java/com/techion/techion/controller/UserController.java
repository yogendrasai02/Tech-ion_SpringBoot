package com.techion.techion.controller;

import com.techion.techion.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @GetMapping("/users")
    public List<User> getUsers() {
        String getUsersApiURI = "https://jsonplaceholder.typicode.com/users";
        User[] users = restTemplate.getForObject(getUsersApiURI, User[].class);
        assert users != null;
        for(User user: users) {
            System.out.println(user);
        }
        return List.of(users);
    }

}
