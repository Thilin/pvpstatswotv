package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import com.mxhstudio.pvpstatswotv.domain.CharacterBuiltSupportAbility;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.CharacterBuiltSupportAbilityRepository;
import com.mxhstudio.pvpstatswotv.repository.SupportAbilityRepository;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltSupportAbilityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;

@Service
public class CharacterBuiltSupportAbilityServiceImpl implements CharacterBuiltSupportAbilityService {

    private final CharacterBuiltSupportAbilityRepository characterBuiltSupportAbilityRepository;
    private final SupportAbilityRepository supportAbilityRepository;

    CharacterBuiltSupportAbilityServiceImpl(CharacterBuiltSupportAbilityRepository characterBuiltSupportAbilityRepository,
                                            SupportAbilityRepository supportAbilityRepository){
        this.characterBuiltSupportAbilityRepository = characterBuiltSupportAbilityRepository;
        this.supportAbilityRepository = supportAbilityRepository;
    }

    @Override
    @Transactional
    public void save(CharacterBuilt characterBuilt, CharacterBuiltCreateDTO dto) {
        dto.getSupportAbilityIds().forEach(id->{
            var builtSupportAbility = new CharacterBuiltSupportAbility();
            var supportAbility = supportAbilityRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(SUPPORT_ABILITY_NAO_ENCONTRADO));
            builtSupportAbility.setCharacterBuilt(characterBuilt);
            builtSupportAbility.setSupportAbility(supportAbility);

            characterBuiltSupportAbilityRepository.save(builtSupportAbility);
        });
    }
}
