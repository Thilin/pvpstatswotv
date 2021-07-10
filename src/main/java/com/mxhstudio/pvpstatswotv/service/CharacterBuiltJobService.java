package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;

public interface CharacterBuiltJobService {
    void save(CharacterBuilt characterBuilt, CharacterBuiltCreateDTO dto);
}
