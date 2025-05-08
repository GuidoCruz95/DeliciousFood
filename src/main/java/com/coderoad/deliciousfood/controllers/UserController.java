package com.coderoad.deliciousfood.controllers;

import com.coderoad.deliciousfood.DTOs.UserDTO;
import com.coderoad.deliciousfood.models.User;
import com.coderoad.deliciousfood.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@RequestBody UserDTO userDTO) {
        User user = userService.register(userDTO.getUser());
        return user.getDTO();
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO login(@RequestBody UserDTO userDTO) {
        User user = userService.register(userDTO.getUser());
        return user.getDTO();
    }
}
