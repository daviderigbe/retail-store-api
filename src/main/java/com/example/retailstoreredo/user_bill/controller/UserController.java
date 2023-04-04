package com.example.retailstoreredo.user_bill.controller;

import com.example.retailstoreredo.user_bill.request.UpdateUserRequest;
import com.example.retailstoreredo.user_bill.service.UserServiceImpl;
import com.example.retailstoreredo.user_bill.model.User;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }
    @PutMapping
    public User updateUser(
            @PathVariable("userId") Long userId,
            @RequestBody UpdateUserRequest request) {
        return userService.updateUser(userId, request);
    }
    @DeleteMapping(path = "{userId}")
    public String deleteUser(
            @PathVariable("userId")Long userId,
            @RequestBody UpdateUserRequest request){
        userService.deleteUser(userId, request);
        String response = "Delete successful";
        return response;
    }

}
