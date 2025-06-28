package com.gymapp.academia.auth.controller;

import com.gymapp.academia.auth.dto.RegisterDTO;
import com.gymapp.academia.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping
    public ResponseEntity<?>register(@RequestBody RegisterDTO dto){
       authService.register(dto);
       return ResponseEntity.ok("Usuario criado com sucesso");
    }
}
