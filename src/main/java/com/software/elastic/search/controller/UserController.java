package com.software.elastic.search.controller;

import com.software.elastic.search.persistence.model.User;
import com.software.elastic.search.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Daniel Nacher 2024-02-10 */
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<?> getUsers() {
        try{
            return ResponseEntity.ok().body(userService.getUsers());
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try{
            return ResponseEntity.ok().body(userService.saveUser(user));
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }

    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getUserByName (@PathVariable String name) {
        try{
            return ResponseEntity.ok().body(userService.getUserByName(name));
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/search/{value}")
    public ResponseEntity<?> getUserByValue(@PathVariable String value) {
        try{
            return ResponseEntity.ok().body(userService.findByNameContainsOrUserNameContainsOrSurnameContains(value));
        }catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

}
