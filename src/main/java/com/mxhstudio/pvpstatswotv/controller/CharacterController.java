package com.mxhstudio.pvpstatswotv.controller;

import com.mxhstudio.pvpstatswotv.dto.CharacterJobResponseDTO;
import com.mxhstudio.pvpstatswotv.dto.CharacterResponseDTO;
import com.mxhstudio.pvpstatswotv.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/characters")
@SecurityRequirement(name = "/v3/api-docs")
public class CharacterController {

    private final CharacterService characterService;

    CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "find character", description = "Find a character using its id")
    public ResponseEntity<CharacterResponseDTO> findById(@PathVariable Long id){
        var dto = characterService.findById(id);
        if(dto == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/all", produces = "application/json")
    @Operation(summary = "list all characters", description = "List all characters with their infos")
    public ResponseEntity<List<CharacterResponseDTO>> listAll(){
        return ResponseEntity.ok().body(characterService.listAll());
    }

    @GetMapping(value = "/{id}/jobs", produces = "application/json")
    @Operation(summary = "List character's jobs", description = "List all jobs of a character using its id")
    public ResponseEntity<List<CharacterJobResponseDTO>> listAllJobsByCharacterId(@PathVariable Long id){
        return ResponseEntity.ok().body(characterService.listAllJobsByCharacterId(id));
    }
}
