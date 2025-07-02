package com.gymapp.academia.auth.service;
import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.LoginDTO;
import com.gymapp.academia.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByUser(name)
                .orElseThrow(() ->new RuntimeException("User not found"));
    }

    public void login(LoginDTO request){
        UsernamePasswordAuthenticationToken userAndPassword = new UsernamePasswordAuthenticationToken(request.name(),request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPassword);
        User user =(User) authentication.getPrincipal();
    }

}
