package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.*;
import com.mxhstudio.pvpstatswotv.repository.*;
import com.mxhstudio.pvpstatswotv.service.ConfrontationDetailService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ConfrontationDetailServiceImpl implements ConfrontationDetailService {

    private final ConfrontationDetailRepository confrontationDetailRepository;
    private final FormationCharacterBuiltRepository formationCharacterBuiltRepository;
    private final CharacterBuiltEquipmentRepository characterBuiltEquipmentRepository;
    private final EquipmentConfrontationDetailRepository equipmentConfrontationDetailRepository;
    private final CharacterBuiltSupportAbilityRepository characterBuiltSupportAbilityRepository;
    private final SupportAbilityConfrontationDetailRepository supportAbilityConfrontationDetailRepository;
    private final CharacterBuiltJobRepository characterBuiltJobRepository;
    private final CharacterJobConfrontationDetailRepository characterJobConfrontationDetailRepository;

    ConfrontationDetailServiceImpl(ConfrontationDetailRepository confrontationDetailRepository,
                                   FormationCharacterBuiltRepository formationCharacterBuiltRepository,
                                   CharacterBuiltEquipmentRepository characterBuiltEquipmentRepository,
                                   EquipmentConfrontationDetailRepository equipmentConfrontationDetailRepository,
                                   CharacterBuiltSupportAbilityRepository characterBuiltSupportAbilityRepository,
                                   SupportAbilityConfrontationDetailRepository supportAbilityConfrontationDetailRepository,
                                   CharacterBuiltJobRepository characterBuiltJobRepository,
                                   CharacterJobConfrontationDetailRepository characterJobConfrontationDetailRepository){
        this.confrontationDetailRepository = confrontationDetailRepository;
        this.formationCharacterBuiltRepository = formationCharacterBuiltRepository;
        this.characterBuiltEquipmentRepository = characterBuiltEquipmentRepository;
        this.equipmentConfrontationDetailRepository = equipmentConfrontationDetailRepository;
        this.characterBuiltSupportAbilityRepository = characterBuiltSupportAbilityRepository;
        this.supportAbilityConfrontationDetailRepository = supportAbilityConfrontationDetailRepository;
        this.characterBuiltJobRepository = characterBuiltJobRepository;
        this.characterJobConfrontationDetailRepository = characterJobConfrontationDetailRepository;
    }

    @Override
    @Transactional
    public void save(Confrontation confrontation) {
        var builts = formationCharacterBuiltRepository.findByFormationId(confrontation.getFormation().getId());
        Long position = 0L;
        for (FormationCharacterBuilt built : builts) {
            var confrontationDetail = new ConfrontationDetail();
            confrontationDetail.setConfrontation(confrontation);
            confrontationDetail.setCharacter(built.getCharacterBuilt().getCharacter());
            confrontationDetail.setEsper(built.getCharacterBuilt().getEsper());
            confrontationDetail.setReaction(built.getCharacterBuilt().getReaction());
            confrontationDetail.setVisionCard(built.getCharacterBuilt().getVisionCard());
            confrontationDetail.setPosition(position);
            confrontationDetailRepository.save(confrontationDetail);
            position++;

            saveEquipmentsConfrontationDetails(confrontationDetail, built.getCharacterBuilt());
            saveSupportAbilityConfrontationDetails(confrontationDetail, built.getCharacterBuilt());
            saveCharacterJobConfrontationDetails(confrontationDetail, built.getCharacterBuilt());
        }
    }

    private void saveCharacterJobConfrontationDetails(ConfrontationDetail confrontationDetail, CharacterBuilt built) {
        var characterBuiltJobs = characterBuiltJobRepository.findByCharacterBuiltId(built.getId());
        characterBuiltJobs.forEach(characterBuiltJob -> {
            var characterJobConfrontationDetail = new CharacterJobConfrontationDetail();
            characterJobConfrontationDetail.setConfrontationDetail(confrontationDetail);
            characterJobConfrontationDetail.setCharacterJob(characterBuiltJob.getCharacterJob());
            characterJobConfrontationDetailRepository.save(characterJobConfrontationDetail);
        });
    }

    private void saveSupportAbilityConfrontationDetails(ConfrontationDetail confrontationDetail, CharacterBuilt built) {
        var characterBuiltSupportAbilities = characterBuiltSupportAbilityRepository.findByCharacterBuiltId(built.getId());
        characterBuiltSupportAbilities.forEach(characterBuiltSupportAbility -> {
            var supportAbilityConfrontationDetail = new SupportAbilityConfrontationDetail();
            supportAbilityConfrontationDetail.setConfrontationDetail(confrontationDetail);
            supportAbilityConfrontationDetail.setSupportAbility(characterBuiltSupportAbility.getSupportAbility());
            supportAbilityConfrontationDetailRepository.save(supportAbilityConfrontationDetail);
        });
    }

    private void saveEquipmentsConfrontationDetails(ConfrontationDetail confrontationDetail, CharacterBuilt built) {
        var characterBuiltEquipments = characterBuiltEquipmentRepository.findByCharacterBuiltId(built.getId());
        characterBuiltEquipments.forEach(characterBuiltEquipment -> {
            var equipmentConfrontationDetail = new EquipmentConfrontationDetail();
            equipmentConfrontationDetail.setConfrontationDetail(confrontationDetail);
            equipmentConfrontationDetail.setEquipment(characterBuiltEquipment.getEquipment());
            equipmentConfrontationDetailRepository.save(equipmentConfrontationDetail);
        });
    }
}
