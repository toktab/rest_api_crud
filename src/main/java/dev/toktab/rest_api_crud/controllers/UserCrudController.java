package dev.toktab.rest_api_crud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.toktab.rest_api_crud.models.User;

@RestController
public class UserCrudController {

    private List<User> users = new ArrayList<>();
    private Long userIdCounter = 1L;

    //GetAll
    @GetMapping
    public List<User> getAllUsers(){
        return users;
    }

    //GetById
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){//@RequestBody User user
        user.setId(userIdCounter++);//For AutoIncrement
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser){//@RequestBody User updatedUser
        Optional<User> existingUser = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        if(existingUser.isPresent()){
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        users.removeIf(user -> user.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
    
}
