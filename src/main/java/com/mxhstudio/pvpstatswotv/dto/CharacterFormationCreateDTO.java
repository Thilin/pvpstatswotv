package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterFormationCreateDTO {

    @Schema(description = "Formation name", example = "GvG")
    private String name;
    @Schema(description = "User's id", example = "1")
    private Long userId;
    private List<PositionFormationCreateDTO> positions;
}
