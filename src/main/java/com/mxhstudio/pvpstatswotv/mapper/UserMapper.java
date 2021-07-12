package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.UserResponseDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class UserMapper {

    PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "nickName", target = "username")
    @Mapping(source = "email", target = "email")
    public abstract User convertToEntity(UserCreateDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "username", target = "nickName")
    @Mapping(source = "email", target = "email")
    public abstract UserResponseDTO convertToDTO(User user);
}
