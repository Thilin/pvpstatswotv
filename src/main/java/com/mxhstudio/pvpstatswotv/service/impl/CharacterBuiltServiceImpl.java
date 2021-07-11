package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.*;
import com.mxhstudio.pvpstatswotv.domain.Character;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.*;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltEquipmentService;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltJobService;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltService;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltSupportAbilityService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;
import static com.mxhstudio.pvpstatswotv.mapper.CharacterBuiltMapper.*;

@Service
public class CharacterBuiltServiceImpl implements CharacterBuiltService {

    private final CharacterBuiltRepository characterBuiltRepository;
    private final VisionCardRepository visionCardRepository;
    private final EsperRepository esperRepository;
    private final CharacterRepository characterRepository;
    private final UserRepository userRepository;
    private final ReactionRepository reactionRepository;
    private final CharacterBuiltEquipmentService characterBuiltEquipmentService;
    private final CharacterBuiltSupportAbilityService characterBuiltSupportAbilityService;
    private final CharacterBuiltJobService characterBuiltJobService;

    CharacterBuiltServiceImpl(CharacterBuiltRepository characterBuiltRepository, VisionCardRepository visionCardRepository,
                              EsperRepository esperRepository, CharacterRepository characterRepository, UserRepository userRepository,
                              ReactionRepository reactionRepository, CharacterBuiltEquipmentService characterBuiltEquipmentService,
                              CharacterBuiltSupportAbilityService characterBuiltSupportAbilityService, CharacterBuiltJobService characterBuiltJobService){
        this.characterBuiltRepository = characterBuiltRepository;
        this.visionCardRepository = visionCardRepository;
        this.esperRepository = esperRepository;
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.reactionRepository = reactionRepository;
        this.characterBuiltEquipmentService = characterBuiltEquipmentService;
        this.characterBuiltSupportAbilityService = characterBuiltSupportAbilityService;
        this.characterBuiltJobService = characterBuiltJobService;
    }

    @Override
    @Transactional
    public Long create(CharacterBuiltCreateDTO dto) {
        var characterBuilt = new CharacterBuilt();
        characterBuilt.setName(dto.getName());
        characterBuilt.setVisionCard(getVisionCard(dto.getVisionCardId()));
        characterBuilt.setEsper(getEsper(dto.getEsperId()));
        characterBuilt.setCharacter(getCharacter(dto.getCharacterId()));
        characterBuilt.setUser(getUser(dto.getUserId()));
        characterBuilt.setReaction(getReaction(dto.getReactionId()));
        characterBuiltRepository.save(characterBuilt);

        saveAddtionalInformation(characterBuilt, dto);

        return characterBuilt.getId();
    }

    @Override
    public List<CharacterBuiltResponseDTO> listAllByUserId(Long id) {
        List<CharacterBuilt> builts = characterBuiltRepository.findByUserId(id);
        return builts.stream().map(characterBuilt -> {
            var dto = INSTANCE.convertToDTO(characterBuilt);
            dto.setEquipments(characterBuiltEquipmentService.listByCharacterBuiltId(characterBuilt.getId()));
            return dto;
        }).collect(Collectors.toList());
    }

    private void saveAddtionalInformation(CharacterBuilt characterBuilt, CharacterBuiltCreateDTO dto) {
        characterBuiltEquipmentService.save(characterBuilt, dto);
        characterBuiltSupportAbilityService.save(characterBuilt, dto);
        characterBuiltJobService.save(characterBuilt, dto);
    }

    private Reaction getReaction(Long reactionId) {
        return reactionRepository.findById(reactionId).orElseThrow(()-> new ObjectNotFoundException(REACTION_NAO_ENCONTRADO));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ObjectNotFoundException(USER_NAO_ENCONTRADO));
    }

    private Character getCharacter(Long characterId) {
        return characterRepository.findById(characterId).orElseThrow(()-> new ObjectNotFoundException(CHARACTER_NAO_ENCONTRADO));
    }

    private Esper getEsper(Long esperId) {
        return esperRepository.findById(esperId).orElseThrow(()-> new ObjectNotFoundException(ESPER_NAO_ENCONTRADO));
    }

    private VisionCard getVisionCard(Long visionCardId) {
        return visionCardRepository.findById(visionCardId).orElseThrow(()-> new ObjectNotFoundException(VISION_CARD_NAO_ENCONTRADO));
    }
}
