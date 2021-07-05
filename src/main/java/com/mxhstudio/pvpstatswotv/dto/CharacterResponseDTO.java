package com.mxhstudio.pvpstatswotv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterResponseDTO {

    private Long id;
    private String name;
    private String image;
    private String rarity;
    private ElementResponseDTO element;
}
