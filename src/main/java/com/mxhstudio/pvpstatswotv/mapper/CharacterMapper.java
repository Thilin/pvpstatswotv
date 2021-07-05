package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.Character;
import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterMapper {

    public static final CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    public abstract CharacterResponseDTO convertToDTO(Character character);
}
