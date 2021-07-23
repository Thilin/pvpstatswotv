package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormationResumeResponseDTO {

    @Schema(description = "Character's name", example = "Duane")
    private String name;
    @Schema(description = "Character's image", example = "Duane.png")
    private String image;
}
