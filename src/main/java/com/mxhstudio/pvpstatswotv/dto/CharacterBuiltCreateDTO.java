package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltCreateDTO {

    private String name;
    private Long visionCardId;
    private Long esperId;
    private Long characterId;
    private Long userId;
    private Long reactionId;
    private List<Long> jobsId;
    private List<Long> equipmentIds;
    private List<Long> supportAbilityIds;
}
