package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EsperResponseDTO {

    @Schema(description = "Esper id", example = "1")
    private Long id;
    @Schema(description = "Esper name", example = "Ifrit")
    private String name;
    @Schema(description = "Esper image", example = "Ifrit")
    private String image;
    @Schema(description = "Esper rarity", example = "UR")
    private String rarity;
    private ElementResponseDTO element;
}
