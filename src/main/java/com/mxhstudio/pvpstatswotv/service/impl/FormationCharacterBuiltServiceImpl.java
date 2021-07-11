package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.Formation;
import com.mxhstudio.pvpstatswotv.domain.FormationCharacterBuilt;
import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.CharacterBuiltRepository;
import com.mxhstudio.pvpstatswotv.repository.FormationCharacterBuiltRepository;
import com.mxhstudio.pvpstatswotv.service.FormationCharacterBuiltService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;

@Service
public class FormationCharacterBuiltServiceImpl implements FormationCharacterBuiltService {

    private final FormationCharacterBuiltRepository formationCharacterBuiltRepository;
    private final CharacterBuiltRepository characterBuiltRepository;

    FormationCharacterBuiltServiceImpl(FormationCharacterBuiltRepository formationCharacterBuiltRepository,
                                       CharacterBuiltRepository characterBuiltRepository){
        this.formationCharacterBuiltRepository = formationCharacterBuiltRepository;
        this.characterBuiltRepository = characterBuiltRepository;
    }

    @Override
    @Transactional
    public void saveFormation(CharacterFormationCreateDTO dto, Formation formation) {
        dto.getPositions().forEach(position->{
            var formationCharacterBuilt = new FormationCharacterBuilt();
            formationCharacterBuilt.setPosition(position.getPosition());
            formationCharacterBuilt.setFormation(formation);
            formationCharacterBuilt.setCharacterBuilt(characterBuiltRepository.findById(position.getCharacterBuiltId()).orElseThrow(()-> new ObjectNotFoundException(CHARACTER_BUILT_NAO_ENCONTRADO)));
            formationCharacterBuiltRepository.save(formationCharacterBuilt);
        });

    }
}
