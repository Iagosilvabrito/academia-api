package com.gymapp.academia.auth.controller;

import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.UserDTO;
import com.gymapp.academia.auth.mapper.UserMapper;
import com.gymapp.academia.auth.repository.UserRepository;
import com.gymapp.academia.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> profile(){
        User user = userService.userProfile();

        return ResponseEntity.ok(UserMapper.toDTO(user));
    }
}
