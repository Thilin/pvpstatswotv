package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WinFormationDTO {

    private Long ccfId;
    private String character1;
    private String character2;
    private String character3;
    private Long winCount;
}
