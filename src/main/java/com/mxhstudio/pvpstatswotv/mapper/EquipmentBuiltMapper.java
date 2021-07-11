package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.Equipment;
import com.mxhstudio.pvpstatswotv.dto.EquipmentBuiltResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EquipmentBuiltMapper {

    public static final EquipmentBuiltMapper INSTANCE  = Mappers.getMapper(EquipmentBuiltMapper.class);

    public abstract EquipmentBuiltResponseDTO convertToDTO(Equipment equipment);
}
