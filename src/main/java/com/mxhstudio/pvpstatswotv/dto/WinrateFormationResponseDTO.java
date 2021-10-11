package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WinrateFormationResponseDTO {

    private String character1;
    private String character2;
    private String character3;
    private Double winrate;
}
