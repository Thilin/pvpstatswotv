package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;

import java.util.List;

public interface CharacterService {

    CharacterResponseDTO findById(Long id);
    List<CharacterResponseDTO> listAll();
}
