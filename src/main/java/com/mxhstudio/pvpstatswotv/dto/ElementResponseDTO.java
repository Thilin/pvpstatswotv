package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementResponseDTO {

    @Schema(description = "Element's description", example = "Dark")
    private String description;
    @Schema(description = "Element's image", example = "dark.png")
    private String image;
}
