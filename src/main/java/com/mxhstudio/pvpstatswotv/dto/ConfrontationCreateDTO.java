package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfrontationCreateDTO {

    private LocalDate date;
    private Long unitsLost;
    private Long formationId;
    private Long unitsDefeated;
    private Long userId;
    private Long seasonId;
}
