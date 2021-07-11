package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.EquipmentBuiltResponseDTO;

import java.util.List;

public interface CharacterBuiltEquipmentService {

    void save(CharacterBuilt characterBuilt, CharacterBuiltCreateDTO dto);

    List<EquipmentBuiltResponseDTO> listByCharacterBuiltId(Long id);
}
