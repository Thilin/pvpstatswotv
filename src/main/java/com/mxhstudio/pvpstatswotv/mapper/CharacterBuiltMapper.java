package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CharacterBuiltMapper {

    public static final CharacterBuiltMapper INSTANCE = Mappers.getMapper(CharacterBuiltMapper.class);

    public abstract CharacterBuiltResponseDTO convertToDTO(CharacterBuilt characterBuilt);
}
