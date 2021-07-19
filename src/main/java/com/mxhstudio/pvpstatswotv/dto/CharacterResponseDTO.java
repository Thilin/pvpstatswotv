package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterResponseDTO {

    @Schema(description = "Character's id", example = "1")
    private Long id;
    @Schema(description = "Character's name", example = "Duane")
    private String name;
    @Schema(description = "Character's image", example = "duane.png")
    private String image;
    @Schema(description = "Character's rarity", example = "UR")
    private String rarity;
    @Schema(description = "Character's element")
    private ElementResponseDTO element;
}
