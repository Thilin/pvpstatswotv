package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentResponseDTO {

    @Schema(description = "Equipment id", example = "1")
    private Long id;
    @Schema(description = "Equipment name", example = "Kunai")
    private String name;
    @Schema(description = "Equipment image", example = "Kunai")
    private String image;
    @Schema(description = "Equipment rarity", example = "N")
    private String rarity;
    @Schema(description = "show i equipment is TMR", example = "false")
    private boolean isTMR;
    private EquipmentTypeResponseDTO equipmentType;
    private EquipmentCategoryResponseDTO equipmentCategory;
}
