package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterFormationCreateDTO;
import com.mxhstudio.pvpstatswotv.dto.FormationResumeResponseDTO;
import com.mxhstudio.pvpstatswotv.service.FormationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/formations")
public class FormationController {

    private final FormationService formationService;

    FormationController(FormationService formationService){
        this.formationService = formationService;
    }

    @PutMapping(consumes = "application/json")
    @Operation(summary = "Create new formation", description = "Create a new user's formation")
    public ResponseEntity<Void> create(@RequestBody CharacterFormationCreateDTO dto){
        long id = formationService.create(dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{userId}", produces = "application/json")
    @Operation(summary = "list user's formation", description = "List all user formation")
    public List<FormationResumeResponseDTO> listAllByUserId(@PathVariable Long userId){
        return formationService.listAllByUserId(userId);
    }
}
