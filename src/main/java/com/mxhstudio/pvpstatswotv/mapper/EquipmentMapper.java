package com.mxhstudio.pvpstatswotv.mapper;

import com.mxhstudio.pvpstatswotv.domain.Equipment;
import com.mxhstudio.pvpstatswotv.dto.EquipmentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EquipmentMapper {

    public static final EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    public abstract EquipmentResponseDTO convertToDTO(Equipment equipment);
}
