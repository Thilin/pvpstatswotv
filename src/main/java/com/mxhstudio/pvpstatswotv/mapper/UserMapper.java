package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.UserCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "nickName", target = "username")
    @Mapping(source = "email", target = "email")
    public abstract User convertToEntity(UserCreateDTO dto);
}
