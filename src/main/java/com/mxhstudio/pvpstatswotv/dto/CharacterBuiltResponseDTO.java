package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltResponseDTO {

    private Long id;
    private String name;
    private VisionCardResponseDTO visionCard;
    private EsperResponseDTO esper;
    private CharacterResponseDTO character;
    private List<EquipmentBuiltResponseDTO> equipments;
}
