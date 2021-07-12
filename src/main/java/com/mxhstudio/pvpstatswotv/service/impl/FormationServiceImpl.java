package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.Formation;
import com.mxhstudio.pvpstatswotv.domain.User;
import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.FormationResumeResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.FormationCharacterBuiltRepository;
import com.mxhstudio.pvpstatswotv.repository.FormationRepository;
import com.mxhstudio.pvpstatswotv.repository.UserRepository;
import com.mxhstudio.pvpstatswotv.service.FormationCharacterBuiltService;
import com.mxhstudio.pvpstatswotv.service.FormationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;
import static com.mxhstudio.pvpstatswotv.mapper.CharacterMapper.*;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final UserRepository userRepository;
    private final FormationCharacterBuiltService formationCharacterBuiltService;
    private final FormationCharacterBuiltRepository formationCharacterBuiltRepository;

    FormationServiceImpl(FormationRepository formationRepository, UserRepository userRepository,
                         FormationCharacterBuiltService formationCharacterBuiltService,
                         FormationCharacterBuiltRepository formationCharacterBuiltRepository){
        this.formationRepository = formationRepository;
        this.userRepository = userRepository;
        this.formationCharacterBuiltService = formationCharacterBuiltService;
        this.formationCharacterBuiltRepository = formationCharacterBuiltRepository;
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

    @Override
    public List<FormationResumeResponseDTO> listAllByUserId(Long userId) {
        List<Formation> formations = formationRepository.findByUserId(userId);
        List<FormationResumeResponseDTO> dtoList = new ArrayList<>();
        formations.forEach(formation -> {
            var characterFormations = formationCharacterBuiltRepository.findByFormationId(formation.getId());
            characterFormations.forEach(built ->{
                var dto = INSTANCE.convertToResumeDTO(built.getCharacterBuilt().getCharacter());
                dtoList.add(dto);
            });
            }
        );
        return dtoList;
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ObjectNotFoundException(USER_NAO_ENCONTRADO));
    }
}
