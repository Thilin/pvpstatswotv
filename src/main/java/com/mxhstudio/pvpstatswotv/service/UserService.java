package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<User> listAll();

    Long create(UserCreateDTO dto);

    User findByUserId(Long userId);
}
