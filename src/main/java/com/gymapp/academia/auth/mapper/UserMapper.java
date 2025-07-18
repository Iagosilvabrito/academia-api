package com.gymapp.academia.auth.mapper;

import com.gymapp.academia.aluno.dto.AlunoResponseDTO;
import com.gymapp.academia.auth.domain.Role;
import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.UserDTO;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public static User toEntity(String username, String passwordencrypted){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordencrypted);
        user.setRoles(Role.ALUNO);
        return user;
    }


    public static UserDTO toDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getRoles()
                );
    }
}
