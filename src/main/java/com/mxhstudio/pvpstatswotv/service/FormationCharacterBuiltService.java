package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.domain.Formation;
import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;

public interface FormationCharacterBuiltService {

    void saveFormation(CharacterFormationCreateDTO dto, Formation formation);
}
