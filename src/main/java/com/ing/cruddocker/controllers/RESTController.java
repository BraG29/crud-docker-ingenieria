package com.ing.cruddocker.controllers;

import com.ing.cruddocker.entities.User;
import com.ing.cruddocker.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    private final UserRepository userRepository;

    public RESTController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if(user.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.ok("Se ha eliminado el usuario con id: " + id);
        }

        return ResponseEntity.notFound().build();
    }

}
