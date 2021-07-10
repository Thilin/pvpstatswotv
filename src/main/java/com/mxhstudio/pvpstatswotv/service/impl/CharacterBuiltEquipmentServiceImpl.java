package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.domain.CharacterBuilt;
import com.mxhstudio.pvpstatswotv.domain.CharacterBuiltEquipment;
import com.mxhstudio.pvpstatswotv.dto.CharacterBuiltCreateDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.CharacterBuiltEquipmentRepository;
import com.mxhstudio.pvpstatswotv.repository.EquipmentRepository;
import com.mxhstudio.pvpstatswotv.service.CharacterBuiltEquipmentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;

@Service
public class CharacterBuiltEquipmentServiceImpl implements CharacterBuiltEquipmentService {

    private final CharacterBuiltEquipmentRepository characterBuiltEquipmentRepository;
    private final EquipmentRepository equipmentRepository;

    CharacterBuiltEquipmentServiceImpl(CharacterBuiltEquipmentRepository characterBuiltEquipmentRepository,
                                       EquipmentRepository equipmentRepository){
        this.characterBuiltEquipmentRepository = characterBuiltEquipmentRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    @Transactional
    public void save(CharacterBuilt characterBuilt, CharacterBuiltCreateDTO dto) {

        dto.getEquipmentIds().forEach(id ->{
            var builtEquipment = new CharacterBuiltEquipment();
            var equipment = equipmentRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(EQUIPMENT_NAO_ENCONTRADO));
            builtEquipment.setCharacterBuilt(characterBuilt);
            builtEquipment.setEquipment(equipment);
            characterBuiltEquipmentRepository.save(builtEquipment);
        });
    }
}
