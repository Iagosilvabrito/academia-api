package com.gymapp.academia.auth.controller;

import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.LoginDTO;
import com.gymapp.academia.auth.dto.RegisterDTO;
import com.gymapp.academia.auth.service.AuthService;
import com.gymapp.academia.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academia/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired


    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegisterDTO request){
       userService.register(request);
       return ResponseEntity.ok("Usuario criado com sucesso");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO request){

        return ResponseEntity.ok("Usuario logado com sucesso");
    }
}
