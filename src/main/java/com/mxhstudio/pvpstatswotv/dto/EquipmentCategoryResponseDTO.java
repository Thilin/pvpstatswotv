package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentCategoryResponseDTO {

    @Schema(description = "Equipment category id", example = "1")
    private Long id;
    @Schema(description = "Equiepment category description", example = "Ninja Blade")
    private String description;
}
