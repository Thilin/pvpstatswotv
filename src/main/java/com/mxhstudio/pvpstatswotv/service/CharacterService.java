package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.CharacterJobResponseDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;
import com.mxhstudio.pvpstatswotv.dto.JobResponseDTO;

import java.util.List;

public interface CharacterService {

    CharacterResponseDTO findById(Long id);
    List<CharacterResponseDTO> listAll();

    List<CharacterJobResponseDTO> listAllJobsByCharacterId(Long id);
}
