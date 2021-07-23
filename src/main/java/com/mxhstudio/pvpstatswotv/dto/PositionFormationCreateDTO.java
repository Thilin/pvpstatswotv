package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionFormationCreateDTO {

    @Schema(description = "Character position in formation", example = "1")
    private Long position;
    @Schema(description = "Character build id", example = "1")
    private Long characterBuiltId;
}
