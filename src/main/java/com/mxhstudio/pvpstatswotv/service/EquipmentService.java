package com.mxhstudio.pvpstatswotv.service;

import com.mxhstudio.pvpstatswotv.dto.EquipmentResponseDTO;

import java.util.List;

public interface EquipmentService {

    EquipmentResponseDTO findById(Long id);
    List<EquipmentResponseDTO> listAll();
}
