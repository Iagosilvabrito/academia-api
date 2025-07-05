package com.gymapp.academia.auth.service;

import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.LoginDTO;
import com.gymapp.academia.config.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public String login(LoginDTO request) {
        UsernamePasswordAuthenticationToken userAndPassword =
                new UsernamePasswordAuthenticationToken(request.username(), request.password());

        Authentication authentication = authenticationManager.authenticate(userAndPassword);

        User user = (User) authentication.getPrincipal();


        return tokenService.generateToken(user);
    }
}
