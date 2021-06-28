package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import com.mxhstudio.pvpstatswotv.repository.UserRepository;
import com.mxhstudio.pvpstatswotv.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mxhstudio.pvpstatswotv.mapper.UserMapper.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserCreateDTO dto) {
        User user = INSTANCE.convertToEntity(dto);
        user.setPassword(dto.getPassword());
        userRepository.save(user);
        return user;
    }
}
