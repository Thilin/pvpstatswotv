package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterFormationCreateDTO {

    private String name;
    private Long userId;
    private List<PositionFormationCreateDTO> positions;
}
