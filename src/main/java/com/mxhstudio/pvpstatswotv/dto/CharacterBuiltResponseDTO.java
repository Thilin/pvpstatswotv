package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltResponseDTO {

    @Schema(description = "Build id", example = "1")
    private Long id;
    @Schema(description = "Build name", example = "Duane arena")
    private String name;
    private VisionCardResponseDTO visionCard;
    private EsperResponseDTO esper;
    private CharacterResponseDTO character;
    private List<EquipmentBuiltResponseDTO> equipments;
}
