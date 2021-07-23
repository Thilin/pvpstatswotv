package com.mxhstudio.pvpstatswotv.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfrontationCreateDTO {

    @Schema(description = "Confrontation date", example = "2021-02-02")
    private LocalDate date;
    @Schema(description = "total of unit lost in battle", example = "2")
    private Long unitsLost;
    @Schema(description = "formation id", example = "2")
    private Long formationId;
    @Schema(description = "Enemy's unit defeated in battle", example = "3")
    private Long unitsDefeated;
    @Schema(description = "User's id", example = "1")
    private Long userId;
    @Schema(description = "Season's id", example = "1")
    private Long seasonId;
}
