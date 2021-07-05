package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.EquipmentResponseDTO;
import com.mxhstudio.pvpstatswotv.service.EquipmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentController {

    private final EquipmentService equipmentService;

    EquipmentController(EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @GetMapping(value = "/{id}")
    public EquipmentResponseDTO findById(@PathVariable Long id){
        return equipmentService.findById(id);
    }

    @GetMapping(value = "/all")
    public List<EquipmentResponseDTO> listAll(){
        return equipmentService.listAll();
    }
}
