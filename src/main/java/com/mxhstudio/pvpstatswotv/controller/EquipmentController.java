package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.EquipmentResponseDTO;
import com.mxhstudio.pvpstatswotv.service.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "find equipment",description = "Find an equipment using its id")
    public ResponseEntity<EquipmentResponseDTO> findById(@PathVariable Long id){
        var dto = equipmentService.findById(id);
        if(dto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/all", produces = "application/json")
    @Operation(summary = "List all equipments", description = "List all equipments with their informations")
    public ResponseEntity<List<EquipmentResponseDTO>> listAll(){
        return ResponseEntity.ok().body(equipmentService.listAll());
    }
}
