package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import com.mxhstudio.pvpstatswotv.repository.UserRepository;
import com.mxhstudio.pvpstatswotv.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mxhstudio.pvpstatswotv.mapper.UserMapper.*;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public Long create(UserCreateDTO dto) {
        final var user = INSTANCE.convertToEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User findByUserId(Long userId) {
        return null;
    }
}
