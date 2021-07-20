package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisionCardResponseDTO {

    @Schema( description = "Vision card id", example = "1")
    private  Long id;
    @Schema(description = "Vision card description", example = "Ifrit")
    private  String description;
    @Schema(description = "Vision card image", example = "Ifrit")
    private  String image;
}
