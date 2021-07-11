package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltResponseDTO;

import java.util.List;

public interface CharacterBuiltService {

    Long create(CharacterBuiltCreateDTO dto);

    List<CharacterBuiltResponseDTO> listAllByUserId(Long id);
}
