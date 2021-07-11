package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.*;
import com.mxhstudio.pvpstatswotv.dto.ConfrontationCreateDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.*;
import com.mxhstudio.pvpstatswotv.service.ConfrontationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;

@Service
public class ConfrontationServiceImpl implements ConfrontationService {

    private final ConfrontationRepository confrontationRepository;
    private final FormationRepository formationRepository;
    private final FormationCharacterBuiltRepository formationCharacterBuiltRepository;
    private final ConfrontationCharacterFormationRepository confrontationCharacterFormationRepository;
    private final SeasonRepository seasonRepository;
    private final UserRepository userRepository;

    ConfrontationServiceImpl(ConfrontationRepository confrontationRepository, FormationRepository formationRepository,
                             FormationCharacterBuiltRepository formationCharacterBuiltRepository,
                             ConfrontationCharacterFormationRepository confrontationCharacterFormationRepository,
                             SeasonRepository seasonRepository, UserRepository userRepository){
        this.confrontationRepository = confrontationRepository;
        this.formationRepository = formationRepository;
        this.formationCharacterBuiltRepository = formationCharacterBuiltRepository;
        this.confrontationCharacterFormationRepository = confrontationCharacterFormationRepository;
        this.seasonRepository = seasonRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Long create(ConfrontationCreateDTO dto) {
        var confrontation = new Confrontation();

        var formation = formationRepository.findById(dto.getFormationId()).orElseThrow(()-> new ObjectNotFoundException(FORMATION_NAO_ENCONTRADO));
        var confrontationCharacterFormation = getConfrontationCharacterFormation(formation);

        confrontation.setDate(dto.getDate());
        confrontation.setUnitsDefeated(dto.getUnitsDefeated());
        confrontation.setUnitsLost(dto.getUnitsLost());
        confrontation.setWin(dto.getUnitsDefeated() == 3);
        confrontation.setConfrontationCharacterFormation(confrontationCharacterFormation);
        confrontation.setFormation(formation);
        confrontation.setSeason(getSeason(dto.getSeasonId()));
        confrontation.setUser(getUser(dto.getUserId()));

        confrontationRepository.save(confrontation);
        return confrontation.getId();
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ObjectNotFoundException(USER_NAO_ENCONTRADO));
    }

    private Season getSeason(Long seasonId) {
        return seasonRepository.findById(seasonId).orElseThrow(() -> new ObjectNotFoundException(SEASON_NAO_ENCONTRADO));
    }

    private ConfrontationCharacterFormation getConfrontationCharacterFormation(Formation formation) {
        var characterBuiltFormationList = formationCharacterBuiltRepository.findByFormationId(formation.getId());
        var name1 = characterBuiltFormationList.get(0).getCharacterBuilt().getCharacter().getName();
        var name2 = characterBuiltFormationList.get(1).getCharacterBuilt().getCharacter().getName();
        var name3 = characterBuiltFormationList.get(2).getCharacterBuilt().getCharacter().getName();

        if(confrontationCharacterFormationRepository.existsByCharacter1AndAndCharacter2AndCharacter3(name1, name2, name3))
            return confrontationCharacterFormationRepository.findByCharacter1AndAndCharacter2AndCharacter3(name1, name2, name3);
        else{
            var confrontationCharacterFormation = new ConfrontationCharacterFormation();
            confrontationCharacterFormation.setCharacter1(name1);
            confrontationCharacterFormation.setCharacter2(name2);
            confrontationCharacterFormation.setCharacter3(name3);
            confrontationCharacterFormationRepository.save(confrontationCharacterFormation);
            return confrontationCharacterFormation;
        }
    }
}