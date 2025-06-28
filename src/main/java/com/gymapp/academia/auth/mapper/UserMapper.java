package com.gymapp.academia.auth.mapper;

import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.RegisterDTO;

public class UserMapper {

    public static User toEntity(RegisterDTO dto,String passwordencrypted){
        User user = new User();
        user.setName(dto.name());
        user.setPassword(passwordencrypted);
        user.setRoles(dto.roles());
        return  user;
    }

}
