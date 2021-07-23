package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltCreateDTO {

    @Schema(description = "Build name", example = "Duane Arena")
    private String name;
    @Schema(description = "Vision card id", example = "1")
    private Long visionCardId;
    @Schema(description = "Esper id", example = "1")
    private Long esperId;
    @Schema(description = "Character id",example = "1")
    private Long characterId;
    @Schema(description = "user id", example = "1")
    private Long userId;
    @Schema(description = "Reaction id", example = "1")
    private Long reactionId;
    private List<Long> jobsId;
    private List<Long> equipmentIds;
    private List<Long> supportAbilityIds;
}
