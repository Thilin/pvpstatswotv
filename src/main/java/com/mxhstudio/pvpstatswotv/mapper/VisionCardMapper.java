package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.VisionCard;
import com.mxhstudio.pvpstatswotv.dto.VisionCardResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class VisionCardMapper {

    public static final VisionCardMapper INSTANCE = Mappers.getMapper(VisionCardMapper.class);

    public abstract VisionCardResponseDTO convertToDTO(VisionCard visionCard);
}
