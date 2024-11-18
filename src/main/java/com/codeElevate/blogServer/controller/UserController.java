package com.codeElevate.blogServer.controller;

import com.codeElevate.blogServer.Dto.UserDTO;
import com.codeElevate.blogServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        try {
            String username = userService.addUser(userDTO);
            return ResponseEntity.ok().body("User " + username + " saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}