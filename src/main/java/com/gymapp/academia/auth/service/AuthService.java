package com.gymapp.academia.auth.service;
import com.gymapp.academia.aluno.domain.Aluno;
import com.gymapp.academia.auth.domain.User;
import com.gymapp.academia.auth.dto.RegisterAlunoDTO;
import com.gymapp.academia.aluno.mapper.AlunoMapper;
import com.gymapp.academia.auth.mapper.UserMapper;
import com.gymapp.academia.aluno.repository.AlunoRepository;
import com.gymapp.academia.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException("User or password not found"));
    }

    public void register(RegisterAlunoDTO dto) {
        if (userRepository.existsByUsername(dto.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Esse usuário já existe");
        }
        String passwordencrypted = passwordEncoder.encode(dto.password());
        User user = UserMapper.toEntity(dto.username(), passwordencrypted);

        userRepository.save(user);


        Aluno aluno = AlunoMapper.toEntity(dto,user);
        alunoRepository.save(aluno);

    }


}
