package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.Esper;
import com.mxhstudio.pvpstatswotv.dto.EsperResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EsperMapper {

    public static final EsperMapper INSTANCE = Mappers.getMapper(EsperMapper.class);

    public abstract EsperResponseDTO convertToDTO(Esper esper);
}
