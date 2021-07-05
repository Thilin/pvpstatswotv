package com.mxhstudio.pvpstatswotv.service.impl;

import com.mxhstudio.pvpstatswotv.dto.EquipmentResponseDTO;
import com.mxhstudio.pvpstatswotv.exceptions.ObjectNotFoundException;
import com.mxhstudio.pvpstatswotv.repository.EquipmentRepository;
import com.mxhstudio.pvpstatswotv.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mxhstudio.pvpstatswotv.exceptions.ErrorConstants.*;
import static com.mxhstudio.pvpstatswotv.mapper.EquipmentMapper.*;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    EquipmentServiceImpl(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public EquipmentResponseDTO findById(Long id) {
        var equipment = equipmentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(EQUIPMENT_NAO_ENCONTRADO));
        return INSTANCE.convertToDTO(equipment);
    }

    @Override
    public List<EquipmentResponseDTO> listAll() {
        var equipments = equipmentRepository.findAll();
        return equipments.stream().map(INSTANCE::convertToDTO).collect(Collectors.toList());
    }
}
