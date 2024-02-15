package com.springlearning.springmongo.resources;

import com.springlearning.springmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User user1 = new User("1", "Teobalda", "maria@mariamail");
        User user2 = new User("1", "Ronaldo", "ronaldo@mariamail");
        List<User> list = new ArrayList<>(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(list);
    }
}
