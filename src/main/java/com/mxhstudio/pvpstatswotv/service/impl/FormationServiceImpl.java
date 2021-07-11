package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.Formation;
import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.FormationRepository;
import com.mxhstudio.pvpstatswotv.repository.UserRepository;
import com.mxhstudio.pvpstatswotv.service.FormationCharacterBuiltService;
import com.mxhstudio.pvpstatswotv.service.FormationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final UserRepository userRepository;
    private final FormationCharacterBuiltService formationCharacterBuiltService;

    FormationServiceImpl(FormationRepository formationRepository, UserRepository userRepository,
                         FormationCharacterBuiltService formationCharacterBuiltService){
        this.formationRepository = formationRepository;
        this.userRepository = userRepository;
        this.formationCharacterBuiltService = formationCharacterBuiltService;
    }

    @Override
    @Transactional
    public Long create(CharacterFormationCreateDTO dto) {
        var formation = new Formation();
        formation.setName(dto.getName());
        formation.setUser(getUser(dto.getUserId()));
        formationRepository.save(formation);
        formationCharacterBuiltService.saveFormation(dto, formation);

        return formation.getId();
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ObjectNotFoundException(USER_NAO_ENCONTRADO));
    }
}
