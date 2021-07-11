package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.FormationResumeResponseDTO;

import java.util.List;

public interface FormationService {

    Long create(CharacterFormationCreateDTO dto);

    List<FormationResumeResponseDTO> listAllByUserId(Long userId);
}
