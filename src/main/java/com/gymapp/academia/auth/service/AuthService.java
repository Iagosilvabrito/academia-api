package com.gymapp.academia.auth.service;

import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.RegisterDTO;
import com.gymapp.academia.auth.mapper.UserMapper;
import com.gymapp.academia.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public void register(RegisterDTO dto){
        if (userRepository.existsByUsername(dto.name())){
            throw new RuntimeException("Esse usuario já existe");
        }
        String passwordencrypted = passwordEncoder.encode(dto.password());
        User user = UserMapper.toEntity(dto,passwordencrypted);
        userRepository.save(user);

    }
}
