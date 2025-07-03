package com.gymapp.academia.auth.controller;

import com.gymapp.academia.auth.dto.LoginDTO;
import com.gymapp.academia.auth.dto.RegisterDTO;
import com.gymapp.academia.auth.service.LoginService;
import com.gymapp.academia.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academia/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;


    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegisterDTO request){
       userService.register(request);
       return ResponseEntity.ok("Usuario criado com sucesso");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO request){

        String token = loginService.login(request);

        return ResponseEntity.ok(token);
    }
}
